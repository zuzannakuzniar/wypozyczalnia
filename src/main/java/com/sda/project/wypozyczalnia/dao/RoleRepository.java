package com.sda.project.wypozyczalnia.dao;

import com.tplesniak.sda.springboot.template.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
