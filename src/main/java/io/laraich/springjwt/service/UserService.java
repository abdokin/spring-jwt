package io.laraich.springjwt.service;

import java.util.List;

import io.laraich.springjwt.model.Role;
import io.laraich.springjwt.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRoles(Role role);
    void addRoleToUser(String username, String roleName);
    // get user by username
    User getUser(String username);
    List<User> getAllUsers();
}
