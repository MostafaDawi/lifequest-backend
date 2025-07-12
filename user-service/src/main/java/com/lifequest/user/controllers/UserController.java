package com.lifequest.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping()
    public String home(){
        return "User service is running...";
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
