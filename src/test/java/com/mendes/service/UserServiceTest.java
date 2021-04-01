package com.mendes.service;

import com.mendes.entity.User;
import com.mendes.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mendes
 */

@SpringBootTest
class UserServiceTest {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final String DEFAULT_NAME = "ALİ";
    private static final String DEFAULT_SURNAME = "CAN";
    private static final String DEFAULT_USERNAME = "ALİCAN";

    User defaultUser;
    User resultUser;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {

        defaultUser = new User();
        defaultUser.setId(DEFAULT_USER_ID);
        defaultUser.setName(DEFAULT_NAME);
        defaultUser.setSurname(DEFAULT_SURNAME);
        defaultUser.setUsername(DEFAULT_USERNAME);
    }

    @AfterEach
    public void clear() {

        if (resultUser != null && (resultUser.getId() != null)) {
            userRepository.deleteById(resultUser.getId());
        }
    }

    @Test
    public void save() {

        resultUser = userService.save(defaultUser);
        assertNotNull(resultUser);
    }

    @Test
    public void list() {

        resultUser = userService.save(defaultUser);
        assertNotNull(resultUser);

        List<User> users = userService.list();
        assertTrue(users.size() > 0);
    }
}