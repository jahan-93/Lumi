package com.example.security.auth.service;

import com.example.security.JwtUtil;
import com.example.security.auth.dto.AuthDTO;
import com.example.security.auth.repository.UserRepository;
import com.example.security.auth.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(AuthDTO dto) {
        if (userRepository.findByNickname(dto.getNickname()).isPresent()) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        UserEntity user = new UserEntity();
        user.setNickname(dto.getNickname());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // 비밀번호 암호화

        userRepository.save(user);
    }

    public String login(AuthDTO dto) {
        UserEntity user = userRepository.findByNickname(dto.getNickname())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        return jwtUtil.generateToken(user.getNickname());
    }
}