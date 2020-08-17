package com.acmday.transaction.server.service;

import com.acmday.transaction.server.bo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
public interface UserMapper {

    @Select("select * from student where id=#{id}")
    List<User> selectUserList(@Param("id") int id, String name);
}
