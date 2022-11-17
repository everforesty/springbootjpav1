package com.example.springbootjpav1.service;

import com.example.springbootjpav1.domain.dto.UserResponse;
import com.example.springbootjpav1.domain.entity.User;
import com.example.springbootjpav1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getOneById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 유저를 찾지 못함"));
        return UserResponse.of(user);
    }
}