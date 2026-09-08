package com.demo.repository;

import com.demo.model.Teacher;

import java.sql.*;


public class TeacherRepository {

    String url =  "jdbc:mysql://localhost:3306/jdbc_demo";
    String user = "root";
    String password = "Manish@18";



    public void createTeacher(Teacher teacher)  {

        String query = """
                         INSERT INTO teachers(Name, Email, Salary)
                         VALUES(?, ?, ?)
                         """;
        try(
                Connection  connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(query);
        )
        {
            statement.setString(1,teacher.getName());
            statement.setString(2,teacher.getEmail());
            statement.setInt(3,teacher.getSalary());

            int result = statement.executeUpdate();

            if (result == 1) {
                System.out.println("Executed");
            }
            else{
                System.out.println("Execution Failed");
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getTeacherById(int id) {

        String query =  """
                SELECT id, name, email, salary FROM teachers
                WHERE id = ?
                """;
        try(
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = connection.prepareStatement(query);
        )
        {
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                double salary = resultSet.getDouble("salary");

                System.out.println(name + " " + email + " " + salary);
            }

            resultSet.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed"+e.getMessage());
        }
    }

    public void getAllTeacher() {

        String query = "select * from teachers";
        try(
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = connection.prepareStatement(query);

        )
        {
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Double salary = resultSet.getDouble("salary");

                System.out.println(name + " " + email + " " + salary);
            }

            resultSet.close();
        }
        catch(SQLException e) {
            System.out.println("Connection failed"+e.getMessage());
        }


    }

    public void updateTeacher(Teacher teacher , int id) {

        String query =  """
                     UPDATE teachers
                     SET name = ?,
                         email = ?,
                         salary = ?
                     WHERE id = ?
                     """;
        try( Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement = connection.prepareStatement(query);
             )
        {
            statement.setString(1,teacher.getName());
            statement.setString(2,teacher.getEmail());
            statement.setDouble(3,teacher.getSalary());
            statement.setInt(4,id);

            int result = statement.executeUpdate();
            System.out.println("Teacher Updated Successfully");


        }
        catch(SQLException e) {
            System.out.println("Connection failed"+e.getMessage());
        }
    }
    public void deleteTeacher(int id) {
        String query = """
                           DELETE from teachers 
                           where id = ?
                                """;

        try(
                Connection connection = DriverManager.getConnection(url, user, password);

                PreparedStatement statement = connection.prepareStatement(query);
                )

        {
            statement.setInt(1,id);

            int result = statement.executeUpdate();

            System.out.println("Teacher Deleted Successfully");

        }
        catch(SQLException e) {
            System.out.println("Connection failed"+e.getMessage());
        }
    }
}

//executeUpdate --> create , update , delete  -- INT
//executeQuery --> read(select)   -- ResultSet
//execute --> General purpose(CRUD)  -- Boolean
