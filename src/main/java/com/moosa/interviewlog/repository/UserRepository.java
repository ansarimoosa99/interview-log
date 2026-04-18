package com.moosa.interviewlog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moosa.interviewlog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}