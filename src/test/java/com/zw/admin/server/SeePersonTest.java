package com.zw.admin.server;

import com.zw.admin.server.dao.SeePersonDao;
import com.zw.admin.server.model.SeePerson;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SeePersonTest {

    @Autowired
    private SeePersonDao seePersonDao;


    @Before
    public void init(){
        seePersonDao.truncate();
        SeePerson seePerson1=new SeePerson();
        seePerson1.setDealDep("test1");
        seePerson1.setDealEmail("test1");
        seePerson1.setDealId(1);
        seePerson1.setDealName("test1");
        seePerson1.setDealNote("test1");
        seePerson1.setDealNumber("test1");
        seePerson1.setRectifictId("test1");
        seePerson1.setDealedEmail("test1");
        seePerson1.setDealedDep("test1");
        seePerson1.setDealedNumber("test1");
        seePerson1.setDealedName("test1");
        seePersonDao.save(seePerson1);
        SeePerson seePerson2=new SeePerson();
        seePerson2.setDealDep("test2");
        seePerson2.setDealEmail("test2");
        seePerson2.setDealId(2);
        seePerson2.setDealName("test2");
        seePerson2.setDealNote("test2");
        seePerson2.setDealNumber("test2");
        seePerson2.setRectifictId("test2");
        seePerson2.setDealedEmail("test2");
        seePerson2.setDealedDep("test2");
        seePerson2.setDealedNumber("test2");
        seePerson2.setDealedName("test2");
        seePersonDao.save(seePerson2);
    }

    @After
    public void after(){
        seePersonDao.truncate();
        init();
    }

    /*
    测试统计功能
     */
    @Test
    public  void testCountPerson(){
        int i=seePersonDao.countSum();
        System.out.println("xxl"+seePersonDao.countSum());
        log.info("countSum={}",i);
        Assert.assertEquals(2,i);
    }

    /*
    测试根据Id获取实体
     */
    @Test
    public void  getPersonByid(){
        SeePerson seePerson=seePersonDao.getById(2);
        Assert.assertEquals(seePerson.getDealDep(),"test2");
    }

    /*
    测试删除方法
     */
    @Test
    public void deletePerson(){
        seePersonDao.delete(1);
        Assert.assertEquals(1,seePersonDao.countSum());
    }

    @Test
    public void updatePerson(){
        SeePerson seePerson=seePersonDao.getById(2);
        seePerson.setDealedName("test02");
        seePersonDao.update(seePerson);
        log.info(seePerson.getDealedName());
        Assert.assertEquals(seePerson.getDealedName(),"test02");
    }
}
