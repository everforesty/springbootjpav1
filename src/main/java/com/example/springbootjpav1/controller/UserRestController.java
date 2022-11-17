package com.example.springbootjpav1.controller;

import com.example.springbootjpav1.domain.dto.UserRequest;
import com.example.springbootjpav1.domain.dto.UserResponse;
import com.example.springbootjpav1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok().body(userService.getOneById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        log.info("addUser : {}", userRequest);
        return ResponseEntity.ok().body(userService.addUser(userRequest));
    }
}