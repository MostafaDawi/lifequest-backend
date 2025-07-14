package com.lifequest.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifequest.common.dto.UserDTO;
import com.lifequest.common.response.ApiResponse;
import com.lifequest.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getUsers(){
        return new ApiResponse<List<UserDTO>>(true, "Users fetched successfully", userService.getAllUsers());
    }

    @PostMapping
    public ApiResponse<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ApiResponse<UserDTO>(true, "User created successfully!", userService.createUser(userDTO));
    }
    
    @GetMapping("/{id}")
    public String getUserId(@PathVariable(name = "id") Long id){
        return "User "+id+" is fetched right";
    }
    @GetMapping("/friend/{id}")
    public String getFriendId(@PathVariable(name = "id") Long id){
        return "Friend "+id+" is fetched.";
    }
}
