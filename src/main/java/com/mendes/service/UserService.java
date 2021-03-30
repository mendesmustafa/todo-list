package com.mendes.service;

import com.mendes.entity.User;
import com.mendes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mendes
 */

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User model) {
        userRepository.save(model);
        return model;
    }

    public List<User> list() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
