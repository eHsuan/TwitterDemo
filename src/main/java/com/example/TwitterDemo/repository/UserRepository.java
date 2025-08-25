package com.example.TwitterDemo.repository;
import com.example.TwitterDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {

}
