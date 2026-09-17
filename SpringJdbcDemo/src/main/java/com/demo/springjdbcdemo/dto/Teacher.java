package com.demo.springjdbcdemo.dto;

public class Teacher {
    private int id;
    private String name;
    private String email;
    private String salary;

    public Teacher(int id, String name, String email, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
