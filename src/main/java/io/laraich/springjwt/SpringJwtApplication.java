package io.laraich.springjwt;

import java.util.ArrayList;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.laraich.springjwt.service.UserService;
import io.laraich.springjwt.model.Role;
import io.laraich.springjwt.model.User;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRoles(new Role("ADMIN_ROLE", null));
			userService.saveRoles(new Role("USER_ROLE", null));
			userService.saveUser(new User("admin", "admin", "laarichabdo@gmail.com", new ArrayList<Role>()));
			// userService.addRoleToUser("admin", "ADMIN_ROLE");

		
			// add 20 users
			for (int i = 0; i < 20; i++) {
				userService.saveUser(new User("user" + i, "user" + i, "user" + i + "@gmail.com", new ArrayList<Role>()));
				// userService.addRoleToUser("user"+ i, "USER_ROLE");
			}

		};
	}

}