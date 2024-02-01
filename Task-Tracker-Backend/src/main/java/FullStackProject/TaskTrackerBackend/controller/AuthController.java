package FullStackProject.TaskTrackerBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FullStackProject.TaskTrackerBackend.dto.JwtAuthResponse;
import FullStackProject.TaskTrackerBackend.dto.LoginDto;
import FullStackProject.TaskTrackerBackend.dto.RegisterDto;
import FullStackProject.TaskTrackerBackend.service.AuthService;

import lombok.AllArgsConstructor;




@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Login REST API
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
//        String response = authService.login(loginDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
         return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
    
}
