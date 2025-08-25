package com.example.TwitterDemo.Mapper;
import com.example.TwitterDemo.DTO.UserDTO;
import com.example.TwitterDemo.DTO.UserRegisterDTO;
import com.example.TwitterDemo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getDisplayName());
    }
    public User toUser(UserDTO userDTO)
    {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setDisplayName(userDTO.getDisplayName());
        return user;
    }
    public User toUser(UserRegisterDTO registerDTO)
    {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setDisplayName(registerDTO.getDisplayName());
        user.setPasswordHash(registerDTO.getPassword());
        return user;
    }
}
