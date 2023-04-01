package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.UserDto;
import com.rmslab.blogmania.entities.User;
import com.rmslab.blogmania.exceptions.ResourceNotFoundException;
import com.rmslab.blogmania.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    private User DtoToUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class) ;
        return user ;
    }

    private UserDto UserToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class) ;
        return userDto ;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtoToUser(userDto) ;
        User savedUser = this.userRepository.save(user) ;
        return UserToDto(savedUser) ;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)) ;
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User updatedUser = userRepository.save(user) ;
        return UserToDto(updatedUser) ;
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)) ;
        return UserToDto(user) ;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll() ;
        return userList.stream().map(user -> UserToDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)) ;
        userRepository.delete(user);
    }
}
