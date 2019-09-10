package com.sda.project.wypozyczalnia.services;

import com.sda.project.wypozyczalnia.dao.UserRepository;

import com.sda.project.wypozyczalnia.dto.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addNewUser(User user) {
        return userRepository.save(createNewUser(user));
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));
            }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User deleteUserById (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));

        userRepository.deleteById(id);
        return user;
    }

    public User updateUserById(Long id, User user) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));

        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setEmail(user.getEmail());
        foundUser.setDlsn(user.getDlsn());
        foundUser.setPassword(user.getPassword());

        return userRepository.save(foundUser);
    }

    public User createNewUser(User user) {
        User result = new User();
        result.setName(user.getName());
        result.setSurname(user.getSurname());
        result.setEmail(user.getEmail());
        result.setDlsn(user.getDlsn());
        result.setPassword(user.getPassword());

        return result;
    }
}


