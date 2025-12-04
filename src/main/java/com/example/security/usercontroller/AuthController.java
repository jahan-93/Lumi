package com.example.security.usercontroller;

import com.example.security.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> request) {
        userService.register(request.get("email"), request.get("password"), request.get("name"));
        return "회원가입 성공";
    }
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String token = userService.login(request.get("email"), request.get("password"));
        return Map.of("token", token);
    }
}