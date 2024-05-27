package com.api_financeira_simplificada.controller;

import com.api_financeira_simplificada.domain.user.User;
import com.api_financeira_simplificada.dto.UserDTO;
import com.api_financeira_simplificada.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    @Operation()
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDTO request) {
        User response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
