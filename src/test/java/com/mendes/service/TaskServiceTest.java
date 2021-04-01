package com.mendes.service;

import com.mendes.entity.Task;
import com.mendes.entity.User;
import com.mendes.repository.TaskRepository;
import com.mendes.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mendes
 */

@SpringBootTest
class TaskServiceTest {

    private static final Long DEFAULT_TASK_ID = 1L;
    private static final String DEFAULT_TITLE = "JAVA";
    private static final String DEFAULT_DESCRIPTION = "LESSON JAVA";

    private static final Long DEFAULT_USER_ID = 1L;
    private static final String DEFAULT_NAME = "ALİ";
    private static final String DEFAULT_SURNAME = "CAN";
    private static final String DEFAULT_USERNAME = "ALİCAN";

    Task defaultTask;
    Task resultTask;
    User defaultUser;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {

        defaultUser = new User();
        defaultUser.setId(DEFAULT_USER_ID);
        defaultUser.setName(DEFAULT_NAME);
        defaultUser.setSurname(DEFAULT_SURNAME);
        defaultUser.setUsername(DEFAULT_USERNAME);

        defaultTask = new Task();
        defaultTask.setId(DEFAULT_TASK_ID);
        defaultTask.setTitle(DEFAULT_TITLE);
        defaultTask.setDescription(DEFAULT_DESCRIPTION);
        defaultTask.setUser(defaultUser);
    }

    @AfterEach
    public void clear() {

        if (defaultTask != null && (defaultTask.getId() != null)) {
            taskRepository.deleteById(defaultTask.getId());
            userRepository.deleteById(defaultUser.getId());
        }
    }

    @Test
    public void save() {

        userRepository.save(defaultUser);
        resultTask = taskService.save(defaultTask);
        assertNotNull(resultTask);
    }

    @Test
    public void list() {

        userRepository.save(defaultUser);
        resultTask = taskService.save(defaultTask);
        assertNotNull(defaultTask);

        List<Task> tasks = taskService.list();
        assertTrue(tasks.size() > 0);
    }
}