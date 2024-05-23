package com.hypad.SpringStud.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private int age;
}
