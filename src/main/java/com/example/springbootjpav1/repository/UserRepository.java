package com.example.springbootjpav1.repository;

import com.example.springbootjpav1.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
