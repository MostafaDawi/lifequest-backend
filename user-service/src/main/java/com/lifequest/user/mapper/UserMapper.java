package com.lifequest.user.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lifequest.common.dto.UserDTO;
import com.lifequest.common.enums.Role;
import com.lifequest.user.model.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper {

    public UserDTO toDTO(User user){

        UserDTO userDto = new UserDTO();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());

        return userDto;
    }
    public User toEntity(UserDTO userDTO){
        
        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setRole(Role.valueOf(userDTO.getRole().toUpperCase()));

        return user;
    }
}
