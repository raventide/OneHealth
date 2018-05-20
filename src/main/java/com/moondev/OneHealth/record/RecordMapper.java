package com.moondev.OneHealth.record;

import com.moondev.OneHealth.record.RecordBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Insert("insert into record(personid,type,value,comments,datetime) values(#{personId},#{type},#{value},#{comments},#{dateTime})")
    @Options(useGeneratedKeys = true,keyColumn = "recordid")
    void insert(RecordBean recordBean);

    @Delete("delete from record where id=#{id}")
    Long delete(long id);

    @Select("select type,value,comments,datetime from record where personid=#{personId}")
    List<RecordBean> selectByPersonId(int personId);
}
