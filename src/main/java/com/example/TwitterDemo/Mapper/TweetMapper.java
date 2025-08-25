package com.example.TwitterDemo.Mapper;
import com.example.TwitterDemo.DTO.TweetDTO;
import com.example.TwitterDemo.model.Tweet;
import com.example.TwitterDemo.model.User;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {
    public TweetDTO toDTO(Tweet tweet)
    {
        return new TweetDTO
                (
                        tweet.getContent(),
                        tweet.getAuthor().getId()
                );
    }
    public Tweet toTweet(TweetDTO tweetDTO, User author)
    {
        Tweet tweet = new Tweet();
        tweet.setContent(tweetDTO.getContent());
        tweet.setAuthor(author);
        return tweet;
    }
}
