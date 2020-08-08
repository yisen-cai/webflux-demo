package com.glancebar.webfluxtutorial.repository;

import com.glancebar.webfluxtutorial.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findTopByUsernameEquals() {
        Optional<User> user = userRepository.findTopByUsernameEquals("User: 1");
        Assertions.assertTrue(user.isPresent());
    }

    @Test
    void findUserByMyOwn() {
        Optional<User> user = userRepository.findUserByMyOwn("User: 1");
        Assertions.assertTrue(user.isPresent());
    }

}