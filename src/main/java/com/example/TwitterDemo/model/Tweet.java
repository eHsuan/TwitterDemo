package com.example.TwitterDemo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // H2/MySQL 常用 IDENTITY
    private Long id;

    @Column(nullable = false, length = 280) // 模擬 Twitter 280 字
    private String content;

    @CreationTimestamp             // 由 Hibernate 自動填入建立時間
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // 關聯到 User
    private User author;

}
