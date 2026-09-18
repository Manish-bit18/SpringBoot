package com.demo.hibernatedemo.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Teacher_Data")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_name",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(name = "teacher_email"
            , length = 100
            , nullable = false
            , unique = true
            , insertable = true
            , updatable = true)
    private String email;


    private String age;

    @Column(precision = 5, scale = 2)     //presion = No of Digit    scale = No of Digits after decimal
    private BigDecimal attendance_Percentage;

    public Teacher() {
    }


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "current_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "current_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "current_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "current_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "current_pincode")
            )
    })
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "parmanent_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "parmanent_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "parmanent_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "parmanent_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "parmanent_pincode")
            )
    })
    private Address permanentAddress;

    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isMonitor;

    @Transient
    private String displayName;

    @Enumerated(EnumType.STRING)
    private TeacherStatus status;

    private LocalDate dateOfBirth;

    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(
            name = "skills",
            joinColumns = @JoinColumn(name = "id")
    )
    private List<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "address",
            joinColumns = @JoinColumn(name = "id")
    )
    private List<Address> address;

    public Teacher(Long id, String name, String email, String age, BigDecimal attendance_Percentage, Address currentAddress, Address permanentAddress, Boolean isMonitor, String displayName, TeacherStatus status, LocalDate dateOfBirth, LocalDateTime createdAt, List<String> skills, List<Address> address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        attendance_Percentage = attendance_Percentage;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.isMonitor = isMonitor;
        this.displayName = displayName;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.skills = skills;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BigDecimal getAttendance_Percentage() {
        return attendance_Percentage;
    }

    public void setAttendance_Percentage(BigDecimal attendance_Percentage) {
        attendance_Percentage = attendance_Percentage;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Boolean getMonitor() {
        return isMonitor;
    }

    public void setMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TeacherStatus getStatus() {
        return status;
    }

    public void setStatus(TeacherStatus status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}