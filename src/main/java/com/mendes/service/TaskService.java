package com.mendes.service;

import com.mendes.entity.Task;
import com.mendes.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mendes
 */

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task model) {
        taskRepository.save(model);
        return model;
    }

    public List<Task> list() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }
}
