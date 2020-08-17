package com.acmday.transaction.dao.service;

import com.acmday.transaction.dao.mapper.StudentMapper;
import com.acmday.transaction.dao.model.Student;
import com.acmday.transaction.dao.model.StudentExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/3.
 */
@Service
@Slf4j
public class DaoStudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<Student> getStudentByName(String name) {
        StudentExample cond = new StudentExample();
        cond.createCriteria().andNameEqualTo(name);
        return studentMapper.selectByExample(cond);
    }

    public String getAddressById(int id) {
        return studentMapper.getAddressById(id);
    }
}
