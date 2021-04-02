package com.mendes.controller;

import com.mendes.entity.User;
import com.mendes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mendes
 */

@Api(value = "user")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "save")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User model) {
        return ResponseEntity.ok(userService.save(model));
    }

    @ApiOperation(value = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(userService.list());
    }
}
