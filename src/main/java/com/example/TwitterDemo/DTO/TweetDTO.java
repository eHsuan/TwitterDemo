package com.example.TwitterDemo.DTO;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TweetDTO {
    private String content;
    private Long authorId;

    // constructor
    public TweetDTO(String content, Long authorId) {
        this.content = content;
        this.authorId = authorId;
    }
}
