package com.demo.cruddtodemo.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {
    @NotBlank(message = "Name Cannot be blank")
    @Size(message = "Student name must be atleast 2 Characters long")
    private String name;

    @Min(value = 18)
    @Max(value = 100)
    private int age;

    @Email
    private String email;

    @NotNull
    private Integer roll_no;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
