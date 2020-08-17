package com.acmday.transaction.dao.service;

import com.acmday.transaction.dao.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/8/17.
 */
@Service
@Slf4j
public class StudentDaoJdbcService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student) {
        String sql = "insert into student values(?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAddress(), student.getAge());
        log.info("act=addStudent update={}", update);
    }
}
