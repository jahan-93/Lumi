package com.example.security.auth.controller;

import com.example.security.auth.dto.AuthDTO;
import com.example.security.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Lumi/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody AuthDTO dto) {
        userService.register(dto);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthDTO dto) {
        String token = userService.login(dto);
        return Map.of("token", token);
    }
}