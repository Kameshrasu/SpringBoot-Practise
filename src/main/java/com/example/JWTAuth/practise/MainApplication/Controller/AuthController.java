package com.example.JWTAuth.practise.MainApplication.Controller;


import com.example.JWTAuth.practise.MainApplication.Controller.dto.LoginRequest;
import com.example.JWTAuth.practise.MainApplication.Model.User;
import com.example.JWTAuth.practise.MainApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userservice;

    @PostMapping("/register")
    public void register(@RequestBody User data){
        userservice.add_user(data);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        String token = userservice.login(
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(token);
    }

}
