package com.example.TwitterDemo.controller;
import com.example.TwitterDemo.model.Tweet;
import com.example.TwitterDemo.Mapper.UserMapper;
import com.example.TwitterDemo.DTO.TweetDTO;
import com.example.TwitterDemo.service.TweetService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService tweetService;
    private final UserMapper userMapper;
    public TweetController(TweetService tweetService, UserMapper userMapper) {
        this.tweetService = tweetService;
        this.userMapper = userMapper;
    }
    @GetMapping
    public Page<TweetDTO> getAllTweets(Pageable pageable) {
        return tweetService.getAllTweets(pageable);
    }
    @GetMapping("/{id}")
    public TweetDTO getTweetById(@PathVariable Long id) {
        return tweetService.getTweetById(id);
    }
    @PostMapping
    public TweetDTO createTweet(@RequestBody TweetDTO tweetDTO) {
        return tweetService.createTweet(tweetDTO);
    }
    @PostMapping("/{id}")
    public TweetDTO updateTweet(@PathVariable Long id, @RequestBody TweetDTO tweetDTO) {
        return tweetService.updateTweet(id, tweetDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable Long id)
    {
        tweetService.deleteTweet(id);
        return ResponseEntity.noContent().build();
    }
}
