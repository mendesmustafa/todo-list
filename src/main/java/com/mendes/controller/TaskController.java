package com.mendes.controller;

import com.mendes.entity.Task;
import com.mendes.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mendes
 */

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Task model) {
        return ResponseEntity.ok(taskService.save(model));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(taskService.list());
    }
}
