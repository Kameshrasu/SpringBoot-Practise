package com.example.JWTAuth.practise.MainApplication.Service;


import com.example.JWTAuth.practise.MainApplication.Model.User;
import com.example.JWTAuth.practise.MainApplication.Repository.UserRepo;
import com.example.JWTAuth.practise.MainApplication.Utility.jwtUtil;
import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private jwtUtil jwtutil;

    public void add_user(User data){
        userrepo.save(data);

    }


    public String login(String email, String password) {

        User user = userrepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtutil.generateToken(email);
    }

    public User getUserByEmail(String email) {
        return userrepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }



}
