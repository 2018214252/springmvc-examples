package com.example.springmvcexamples.example03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class User {
    private int id;
    @Size(min = 2,max = 6)
    private String name;
    @Min(value = 18)
    @Max(value = 60)
    private int age;
    @Email
    private String email;
}
