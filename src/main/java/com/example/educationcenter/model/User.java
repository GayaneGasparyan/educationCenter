package com.example.educationcenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")

public class User {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private int age;
        private String phone_num;
        private String address;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
    @ManyToOne
    private Course course;

    }

