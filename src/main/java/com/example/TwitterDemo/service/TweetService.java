package com.example.TwitterDemo.service;
import com.example.TwitterDemo.Mapper.TweetMapper;
import com.example.TwitterDemo.model.Tweet;
import com.example.TwitterDemo.model.User;
import com.example.TwitterDemo.DTO.TweetDTO;
import com.example.TwitterDemo.repository.TweetRepository;
import com.example.TwitterDemo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    private final TweetMapper tweetMapper;
    public TweetService(TweetRepository tweetRepository, UserRepository userRepository, TweetMapper tweetMapper) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
        this.tweetMapper = tweetMapper;
    }
    public Page<TweetDTO> getAllTweets(Pageable pageable) {
        return tweetRepository.findAll(pageable).map(tweetMapper::toDTO);
    }

    public TweetDTO createTweet(TweetDTO tweetDTO) {
        User author = userRepository.findById(tweetDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetMapper.toTweet(tweetDTO, author);
        Tweet saved = tweetRepository.save(tweet);

        return tweetMapper.toDTO(saved);
    }
    public TweetDTO getTweetById(Long id) {
        return tweetMapper.toDTO(tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found with id: " + id)));
    }
    @Transactional
    public TweetDTO updateTweet(Long id, TweetDTO newData) {
        User author = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tweet not found with id: " + id));

        // 更新欄位
        tweet.setContent(newData.getContent());
        tweet.setAuthor(author);

        // 儲存並回傳
        return tweetMapper.toDTO((tweetRepository.save(tweet)));
    }
    public void deleteTweet(Long id)
    {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found with id: " + id));
        if (tweet != null)
        {
            tweetRepository.delete(tweet);
        }

    }
}
