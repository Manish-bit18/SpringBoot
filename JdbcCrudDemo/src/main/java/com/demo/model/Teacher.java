package com.demo.model;

public class Teacher {
    private int id;
    private String name;
    private String email;
    private int salary;

    public Teacher() {}

    public Teacher(String name, String email, int salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Teacher(int i) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
