package com.example.formregister.model;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Controller
@Entity(name = "register_table")
public class Register implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",columnDefinition = "VARCHAR(200)")
    private String firstName;
    @Column(name = "last_name",columnDefinition = "VARCHAR(200)")
    private String lastName;
    @Column(name = "phone",columnDefinition = "VARCHAR(200)")
    private String phone;
    @Column(name = "email",columnDefinition = "VARCHAR(200)")
    private String email;

    public Register() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Register music = (Register) target;
        if (!music.firstName.matches("^[a-zA-Z]{5,45}$")) {
            errors.rejectValue("firstName", "firstName.invalidFormat");
        }
        if (!music.lastName.matches("^[a-zA-Z]{5,45}$")) {
            errors.rejectValue("lastName", "lastName.invalidFormat");
        }
        if (!music.phone.matches("^(09|08|03)[0-9]{8}$")) {
            errors.rejectValue("phone", "phone.invalidFormat");
        }
        if (!music.email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
    }
