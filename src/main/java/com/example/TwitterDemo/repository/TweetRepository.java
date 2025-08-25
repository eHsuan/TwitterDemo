package com.example.TwitterDemo.repository;
import com.example.TwitterDemo.model.Tweet;
import com.example.TwitterDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByAuthor(User author);
}
