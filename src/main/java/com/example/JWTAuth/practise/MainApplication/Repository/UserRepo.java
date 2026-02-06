package com.example.JWTAuth.practise.MainApplication.Repository;

import com.example.JWTAuth.practise.MainApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
