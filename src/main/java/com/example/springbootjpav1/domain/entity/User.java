package com.example.springbootjpav1.domain.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}