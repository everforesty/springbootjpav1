package com.example.springbootjpav1.service;

import com.example.springbootjpav1.domain.dto.UserRequest;
import com.example.springbootjpav1.domain.dto.UserResponse;
import com.example.springbootjpav1.domain.entity.User;
import com.example.springbootjpav1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getOneById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        } else {
            return new UserResponse(id, "", "해당 id의 유저가 없습니다");
        }
    }

    public UserResponse addUser(UserRequest userRequest) {
        // user req is already in repository, return message NO
        // user req is doesn't exist in repository, return message YES
        if (userRepository.findByUsername(userRequest.getUsername()).isEmpty()) {
            User savedUser = userRepository.save(userRequest.toEntity());
            return new UserResponse(savedUser.getId(), savedUser.getUsername(), "회원 등록 성공하였습니다");
        } else {
            return new UserResponse(userRequest.getId(), userRequest.getUsername(), "해당 유저명은 이미 존재합니다");
        }
    }
}