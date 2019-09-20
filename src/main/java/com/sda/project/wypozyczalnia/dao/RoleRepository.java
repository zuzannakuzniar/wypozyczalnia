package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
