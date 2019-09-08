package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
