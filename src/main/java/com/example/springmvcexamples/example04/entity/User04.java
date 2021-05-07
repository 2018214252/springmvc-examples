package com.example.springmvcexamples.example04.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User04 {
    private String userName;
    private String password;
}
