package com.example.TwitterDemo.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "name")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;  // 登入帳號 or handle

    @Column(nullable = false)
    private String displayName;  // 顯示名稱

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tweet> tweets;

}
