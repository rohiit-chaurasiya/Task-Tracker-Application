package FullStackProject.TaskTrackerBackend.service;

import FullStackProject.TaskTrackerBackend.dto.JwtAuthResponse;
import FullStackProject.TaskTrackerBackend.dto.LoginDto;
import FullStackProject.TaskTrackerBackend.dto.RegisterDto;


public interface AuthService {

    String register(RegisterDto registerDto);

    //String login(LoginDto loginDto);
    JwtAuthResponse login(LoginDto loginDto);
    
}
