package com.moondev.OneHealth.manage;

import com.moondev.OneHealth.manage.PersonBean;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PersonMapper {

    @Insert("insert into people(name,age,comments) values(#{name},#{age},#{comments})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(PersonBean person);

    @Update("update people set name=#{name},age=#{age},comments=#{comments} where id = #{id}")
    Long update(PersonBean person);

    @Delete("delete from people where id=#{id}")
    Long delete(@Param("id") int id);

    @Select("select id,name,age,comments from people")
    List<PersonBean> selectAll();

    @Select("select id,name,age,comments from people where id=#{id}")
    PersonBean selectById(@Param("id") int id);

}

