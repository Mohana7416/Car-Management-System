package com.Spyne.Car_Management_Application.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.GenericArrayType;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String fistName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNUmber;
    private String state;
    private String country;
}