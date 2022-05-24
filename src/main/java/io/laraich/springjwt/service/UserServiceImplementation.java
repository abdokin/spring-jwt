package io.laraich.springjwt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import io.laraich.springjwt.model.Role;
import io.laraich.springjwt.model.User;
import io.laraich.springjwt.repository.RoleRepo;
import io.laraich.springjwt.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService {
    private final UserRepo userRepo;
    
    public UserServiceImplementation(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        // log.info("Saving user: {}", user);
        return userRepo.save(user);
    }

    @Override
    public Role saveRoles(Role role) {
        // log.info("Saving role: {}", role);
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        // print user roles
        
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        // log.info("Getting user: {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        // log.info("Getting all users");
        return userRepo.findAll();
    }
    
}
