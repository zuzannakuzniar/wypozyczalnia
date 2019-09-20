package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.RoleRepository;
import com.sda.project.wypozyczalnia.dao.UserRepository;

import com.sda.project.wypozyczalnia.model.Role;
import com.sda.project.wypozyczalnia.model.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setActive(1);
        userRepository.save(user);
    }

    public User addNewUser(User userForm) {
        return userRepository.save(createNewUser(userForm));
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));
            }

    public List<User> getAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User deleteUserById (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));

        userRepository.deleteById(id);
        return user;
    }

    public User updateUserById(Long id, User userForm) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));

        foundUser.setName(userForm.getName());
        foundUser.setSurname(userForm.getSurname());
        foundUser.setEmail(userForm.getEmail());
        foundUser.setDlsn(userForm.getDlsn());
        foundUser.setPassword(userForm.getPassword());

        return userRepository.save(foundUser);
    }

    private User createNewUser(User userForm) {

        User result = new User();
        result.setName(userForm.getName());
        result.setSurname(userForm.getSurname());
        result.setEmail(userForm.getEmail());
        result.setDlsn(userForm.getDlsn());
        result.setPassword(userForm.getPassword());

        return result;
    }
}


