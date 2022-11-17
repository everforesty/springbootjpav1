package com.example.springbootjpav1.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {
    private Long id;
    private String username;
    private String password;
}