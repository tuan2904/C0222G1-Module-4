package com.example.furama.model;

import javax.persistence.*;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    @Column(columnDefinition = "VARCHAR(200)")
    private String nameEmployee;
    @Column(columnDefinition = "VARCHAR(200)")
    private String birthDayEmployee;
    @Column(columnDefinition = "VARCHAR(200)")
    private String idCarEmployee;
    @Column(columnDefinition = "VARCHAR(200)")
    private String salary;
    @Column(columnDefinition = "VARCHAR(200)")
    private String phone;
    @Column(columnDefinition = "VARCHAR(200)")
    private String email;
    @Column(columnDefinition = "VARCHAR(200)")
    private String address;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_education_degree")
    private EducationDegree educationDegree;
@ManyToOne
@JoinColumn(name = "id_division")
private Division division;

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Employee(int idEmployee,
                    String nameEmployee,
                    String birthDayEmployee,
                    String idCarEmployee,
                    String salary,
                    String phone,
                    String email,
                    String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.birthDayEmployee = birthDayEmployee;
        this.idCarEmployee = idCarEmployee;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthDayEmployee() {
        return birthDayEmployee;
    }

    public void setBirthDayEmployee(String birthDayEmployee) {
        this.birthDayEmployee = birthDayEmployee;
    }

    public String getIdCarEmployee() {
        return idCarEmployee;
    }

    public void setIdCarEmployee(String idCarEmployee) {
        this.idCarEmployee = idCarEmployee;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
