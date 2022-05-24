package io.laraich.springjwt.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.laraich.springjwt.model.Role;
import io.laraich.springjwt.model.User;
import io.laraich.springjwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1")
public class UserResource {

    private final UserService userService;
    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(String username) {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(location).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(location).body(userService.saveRoles(role));
    }
   @PostMapping(value="/user/addRole")
   public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
       return ResponseEntity.ok().build();
   } 
}
@Data 
class RoleToUserForm{
    private String username;
    private String roleName;
    public String getUsername() {
        return this.username;
    }
    public String getRoleName() {
        return this.roleName;
    }
}
 