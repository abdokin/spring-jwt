package io.laraich.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.laraich.springjwt.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
