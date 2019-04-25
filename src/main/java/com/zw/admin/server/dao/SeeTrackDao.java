package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.zw.admin.server.model.SeeTrack;

@Mapper
public interface SeeTrackDao {

    @Select("select * from see_track t where t.id = #{id}")
    SeeTrack getById(Long id);

    @Delete("delete from see_track where id = #{id}")
    int delete(Long id);

    @Update("update see_track set sysname = #{sysname},pre_status  = #{preStatus},now_status = #{nowStatus} where id=#{id}")
    int update(SeeTrack seeTrack);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into see_track(sysname, pre_status, now_status) values(#{sysname}, #{preStatus}, #{nowStatus})")
    int save(SeeTrack seeTrack);
    
    int count(@Param("params") Map<String, Object> params);

    List<SeeTrack> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
