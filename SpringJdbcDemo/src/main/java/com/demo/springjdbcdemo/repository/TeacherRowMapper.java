package com.demo.springjdbcdemo.repository;

import com.demo.springjdbcdemo.dto.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id"));
        teacher.setName(rs.getString("name"));
        teacher.setEmail(rs.getString("email"));
        teacher.setSalary(rs.getString("salary"));

        return teacher;
    }
}
