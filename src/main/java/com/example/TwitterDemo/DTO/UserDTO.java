package com.example.TwitterDemo.DTO;
import lombok.Data;
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String displayName;

    public UserDTO(Long id, String username, String displayName) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
    }
}

