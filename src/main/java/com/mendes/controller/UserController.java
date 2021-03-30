package com.mendes.controller;

import com.mendes.entity.User;
import com.mendes.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mendes
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User model) {
        return ResponseEntity.ok(userService.save(model));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(userService.list());
    }
}
