package com.zw.admin.server.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.zw.admin.server.model.JobModel;
import com.zw.admin.server.service.JobService;

@Configuration
public class JobConfig {

	public static final String KEY = "applicationContextSchedulerContextKey";

	@Bean("adminQuartzScheduler")
	public SchedulerFactoryBean quartzScheduler(DataSource dataSource) {
		SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

		try {
			quartzScheduler.setQuartzProperties(
					PropertiesLoaderUtils.loadProperties(new ClassPathResource("quartz.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		quartzScheduler.setDataSource(dataSource);
		quartzScheduler.setOverwriteExistingJobs(true);
		quartzScheduler.setApplicationContextSchedulerContextKey(KEY);

		return quartzScheduler;
	}

	@Autowired
	private JobService jobService;

	/**
	 * 初始化一个定时删除日志的任务
	 */
	@PostConstruct
	public void initDeleteLogsJob() {
		JobModel jobModel = new JobModel();
		jobModel.setJobName("delete-logs-job");
		jobModel.setCron("0 0 0 * * ?");
		jobModel.setDescription("定时删除三个月前日志");
		jobModel.setSpringBeanName("sysLogServiceImpl");
		jobModel.setMethodName("deleteLogs");
		jobModel.setIsSysJob(true);
		jobModel.setStatus(1);

		jobService.saveJob(jobModel);
	}

}
