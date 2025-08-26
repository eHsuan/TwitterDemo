package com.example.TwitterDemo.service;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import com.example.TwitterDemo.DTO.TweetDTO;
import com.example.TwitterDemo.Mapper.TweetMapper;
import com.example.TwitterDemo.model.Tweet;
import com.example.TwitterDemo.model.User;
import com.example.TwitterDemo.repository.TweetRepository;
import com.example.TwitterDemo.repository.UserRepository;
import com.example.TwitterDemo.service.TweetService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class TweetServiceTest {
    @Mock
    private TweetRepository tweetRepository;   // 假的 TweetRepository

    @Mock
    private TweetMapper tweetMapper;   // 假的 TweetMapper

    @Mock
    private UserRepository userRepository;     // 假的 UserRepository

    @InjectMocks
    private TweetService tweetService;         // 被測的 Service，本體；Mockito 會把上面 @Mock 全部注入進來

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);    // 初始化 @Mock/@InjectMocks
    }

    @Test
    void testCreateTweetUserNotFound() {
        // 模擬查不到使用者
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        TweetDTO tweetDTO = new TweetDTO("User Test4", 99L);

        // 期望丟出 RuntimeException，訊息包含 "User not found"
        assertThatThrownBy(() -> tweetService.createTweet(tweetDTO))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User not found");

        // 通常也會驗證：在找不到使用者時，根本不應該呼叫 save
        verify(tweetRepository, never()).save(any());
    }
}
