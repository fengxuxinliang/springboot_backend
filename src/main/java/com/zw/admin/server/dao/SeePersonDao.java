package com.zw.admin.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zw.admin.server.model.SeePerson;

@Mapper
public interface SeePersonDao {

/*    @Select("select * from see_person t where t.deal_id = #{id}")*/
    SeePerson getById(Integer id);

/*    @Delete("delete from see_person where deal_id = #{id}")*/
    int delete(Integer id);

    int update(SeePerson seePerson);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Insert("insert into see_person(deal_dep, deal_email, deal_id, deal_name, deal_note, deal_number, dealed_dep, dealed_email, dealed_name, dealed_number, rectifict_id) values(#{dealDep}, #{dealEmail}, #{dealId}, #{dealName}, #{dealNote}, #{dealNumber}, #{dealedDep}, #{dealedEmail}, #{dealedName}, #{dealedNumber}, #{rectifictId})")
    int save(SeePerson seePerson);
    
    int count(@Param("params") Map<String, Object> params);

    int countSum();

    List<SeePerson> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);


    void truncate();
}
