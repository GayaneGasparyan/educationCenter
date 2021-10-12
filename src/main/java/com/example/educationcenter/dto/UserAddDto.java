package com.example.educationcenter.dto;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private int age;
    private int phoneNumber;
    private UserType userType;



}
