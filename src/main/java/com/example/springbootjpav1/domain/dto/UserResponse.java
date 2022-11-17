package com.example.springbootjpav1.domain.dto;

import com.example.springbootjpav1.domain.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private Long id;
    private String username;
    private String password;

    // of()를 위한 매개변수 2개짜리 constructor
    public UserResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername());
    }
}