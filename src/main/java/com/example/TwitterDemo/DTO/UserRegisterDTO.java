package com.example.TwitterDemo.DTO;
import lombok.Data;

@Data
public class UserRegisterDTO  {
    private Long id;
    private String username;
    private String displayName;
    private String password;

    public UserRegisterDTO (Long id, String username, String displayName, String password) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
        this.password = password;
    }
}
