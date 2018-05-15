package com.moondev.OneHealth.dao;

import com.moondev.OneHealth.profile.PersonInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PersonMapper {

    @Insert("insert into PersonInfo(name,age,company) values(#{name},#{age},#{company})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(PersonInfo info);

    @Update("update PersonInfo set name=#{name},age=#{age},company=#{company} where id = #{id}")
    Long update(PersonInfo info);

    @Delete("delete from PersonInfo where id=#{id}")
    Long delete(@Param("id") int id);

    @Select("select id,name,age,company from PersonInfo")
    List<PersonInfo> selectAll();

    @Select("select id,name,age,company from PersonInfo where id=#{id}")
    PersonInfo selectById(@Param("id") int id);
}
