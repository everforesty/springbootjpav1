package com.example.springbootjpav1.controller;

import com.example.springbootjpav1.domain.dto.UserResponse;
import com.example.springbootjpav1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getOneByUserId(@PathVariable Long id) {
        log.info("getOneByUserId : {}", id);
        return ResponseEntity.ok(userService.getOneById(id));
    }

}