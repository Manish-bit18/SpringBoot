package com.demo;

import com.demo.repository.TeacherRepository;

public class Main {
    public static void main(String[] args) {

        TeacherRepository teacherRepository = new TeacherRepository();
        //teacherRepository.createTeacher(new Teacher("Sandesh", "s@gmail.com", 9000));

        //teacherRepository.getTeacherById(1);

        //teacherRepository.getAllTeacher();

       //teacherRepository.updateTeacher(new Teacher("Ariz" , "a@gmail.com" ,  2000) , 3);

        teacherRepository.deleteTeacher(1);
    }
}

//jdbc:mysql://127.0.0.1:3306/?user=root