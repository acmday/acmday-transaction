package com.acmday.transaction.server.demo;

import com.acmday.transaction.dao.model.Student;
import com.acmday.transaction.server.BaseClass;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
@Slf4j
public class JdbcDemo extends BaseClass {

    private static final String URL = "jdbc:mysql://localhost:3306/acmday?allowMultiQueries=true&charset=utf8mb4&serverTimezone=UTC&characterEncoding=utf-8";

    @Test
    public void jdbcTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("act=jdbcTest e=", e);
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, "acmday", "acmday");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student limit 5;");

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                byte age = (byte) resultSet.getInt(4);

                students.add(new Student(id, name, address, age));
            }
            log.info("act=jdbcTest students={}", new Gson().toJson(students));
        } catch (SQLException e) {
            log.error("act=jdbcTest e=", e);
        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("act=jdbcTest e=", e);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("act=jdbcTest e=", e);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("act=jdbcTest e=",e);
                }
            }
        }
    }
}
