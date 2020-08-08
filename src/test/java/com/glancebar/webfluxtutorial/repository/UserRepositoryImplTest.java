package com.glancebar.webfluxtutorial.repository;

import com.glancebar.webfluxtutorial.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsernameAndNote() {
        Optional<User> user = userRepository.findByUsernameAndNote("User: 1", "hello 1");
        Assertions.assertTrue(user.isPresent());
    }
}