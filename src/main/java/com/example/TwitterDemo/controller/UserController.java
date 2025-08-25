package com.example.TwitterDemo.controller;
import com.example.TwitterDemo.DTO.UserRegisterDTO;
import com.example.TwitterDemo.model.User;
import com.example.TwitterDemo.DTO.UserDTO;
import com.example.TwitterDemo.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public  UserController(UserService userService)
    {
        this.userService = userService;
    }
    @PostMapping
    public UserDTO registerUser(@RequestBody UserRegisterDTO userDTO)
    {
        return userService.registerUser(userDTO);
    }
    @GetMapping
    public List<UserDTO> getAllUsers()
    {
        return userService.getAllUsers();
    }



}
