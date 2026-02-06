package com.example.JWTAuth.practise.MainApplication.Controller;


import com.example.JWTAuth.practise.MainApplication.Model.User;
import com.example.JWTAuth.practise.MainApplication.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/VERSION1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userdata")
    public User getUserData(Authentication authentication) {

        String email = authentication.getName();

        return userService.getUserByEmail(email);
    }



}
