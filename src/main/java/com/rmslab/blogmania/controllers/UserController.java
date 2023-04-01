package com.rmslab.blogmania.controllers;

import com.rmslab.blogmania.dtos.ApiResponseDto;
import com.rmslab.blogmania.dtos.UserDto;
import com.rmslab.blogmania.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto) ;
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED) ;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int userId) {
        UserDto updatedUser = userService.updateUser(userDto, userId) ;
        return ResponseEntity.ok(updatedUser) ;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(new ApiResponseDto("User Deleted Successfully", true), HttpStatus.OK) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers()) ;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        UserDto user = userService.getUserById(userId) ;
        return ResponseEntity.ok(user) ;
    }
}
