package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto) ;
    UserDto updateUser(UserDto userDto, int userId) ;
    UserDto getUserById(int userId) ;
    List<UserDto> getAllUsers() ;
    void deleteUser(int userId) ;
}
