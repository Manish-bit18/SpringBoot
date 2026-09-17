package com.demo.springjdbcdemo.repository;

import com.demo.springjdbcdemo.dto.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {

        private JdbcTemplate jdbcTemplate;

        //private TeacherRowMapper teacherRowMapper = new TeacherRowMapper();

        private RowMapper<Teacher> rowMapper =                           //Use BeanPropertyRowMapper Directly when the Database table and Entities are in Sequence
                new BeanPropertyRowMapper<>(Teacher.class);

        public  TeacherRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public void createTeacher(Teacher teacher) {
            String sql = """
                         INSERT INTO Teachers(name, email, salary)
                         VALUES(?, ?, ?)
                         """;
            int rowAffected = jdbcTemplate.update(sql,
                    teacher.getName(), teacher.getEmail(), teacher.getSalary());

            if(rowAffected == 1) {
                System.out.println("Create Teacher successful");
            }
            else {
                System.out.println("Create Teacher failed");
            }
        }

        public void updateTeacher(Teacher teacher , int id) {
            String sql = """
                     UPDATE Teachers
                     SET name = ?,
                         email = ?,
                         salary = ?
                     WHERE id = ?
                     """;

            int rowAffected = jdbcTemplate.update(sql,
                    teacher.getName(),
                    teacher.getEmail(),
                    teacher.getSalary(),
                    id);

            if(rowAffected == 1) {
                System.out.println("Update operation successful");
            }
            else {
                System.out.println("Updation failed");
            }
        }

        public void deleteTeacher(int id) {
            String sql = """
            DELETE from Teachers WHERE id = ?
        """;

            int rowAffected = jdbcTemplate.update(sql, id);

            if(rowAffected == 1) {
                System.out.println("Delete operation successful");
            }
            else {
                System.out.println("Deletion failed");
            }
        }

        public Teacher getTeacherById(int id) {

            String sql = """
                SELECT id, name, email, salary FROM Teachers
                WHERE id = ?
                """;

            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        }

        public List<Teacher> getTeacher() {
            String sql = """
                SELECT id, name, email, salary FROM Teachers
                """;

            List<Teacher> Teachers = jdbcTemplate.query(sql, rowMapper);

            return Teachers;
        }
    }