package com.example.JWTAuth.practise.MainApplication.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

@Data
@Entity


public class User {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @Email
    String email;

    String password;
}
