package com.java.taskmanager.controllers;

import com.java.taskmanager.dtos.AuthenticationDTO;
import com.java.taskmanager.entities.User;
import com.java.taskmanager.repositories.UserRepository;
import com.java.taskmanager.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AuthenticationDTO authenticationDTO){
        if(userRepository.findByUsername(authenticationDTO.username()) != null) return ResponseEntity.badRequest().body("Username already exists");

        String encryptedPassword = new BCryptPasswordEncoder().encode(authenticationDTO.password());

        userRepository.save(new User(authenticationDTO.username(), encryptedPassword));

        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }
}
