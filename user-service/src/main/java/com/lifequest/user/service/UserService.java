package com.lifequest.user.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lifequest.common.dto.UserDTO;
import com.lifequest.common.enums.Role;
import com.lifequest.common.errorHandling.ResourceNotFoundException;
import com.lifequest.user.mapper.UserMapper;
import com.lifequest.user.model.User;
import com.lifequest.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserDTO getUserbyId(Long id){
        User user = userRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("No user havign the ID "+id+" has been found"));
        return userMapper.toDTO(user);
    }

    public UserDTO getUserByEmail(String email){
        User user = userRepository.findByEmail(email).orElseThrow(
            ()->new ResourceNotFoundException("No by this email was found"));
        
        return userMapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDto){
        User user = new User();
        
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public void deleteUserById(){

    }

    public void updateUser(){

    }

    
}
