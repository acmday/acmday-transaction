package com.acmday.transaction.dao.mapper;

import com.acmday.transaction.dao.model.Student;
import com.acmday.transaction.dao.model.StudentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @Select(value = "select address from student where id=#{id}")
    String getAddressById(int id);
}