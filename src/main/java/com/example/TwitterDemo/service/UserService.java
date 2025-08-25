package com.example.TwitterDemo.service;

import com.example.TwitterDemo.DTO.UserDTO;
import com.example.TwitterDemo.DTO.UserRegisterDTO;
import com.example.TwitterDemo.Mapper.UserMapper;
import com.example.TwitterDemo.model.User;
import com.example.TwitterDemo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }
    public UserDTO registerUser(UserRegisterDTO registerDTO) {
        User user = userMapper.toUser(registerDTO);
        // 加密密碼
        user.setPasswordHash(passwordEncoder.encode(registerDTO.getPassword()));

        User savedUser = userRepository.save(user);

        // 回傳安全的 UserDTO
        return userMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }
}
