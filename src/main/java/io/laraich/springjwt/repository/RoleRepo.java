package io.laraich.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.laraich.springjwt.model.Role;

public  interface RoleRepo  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
    

