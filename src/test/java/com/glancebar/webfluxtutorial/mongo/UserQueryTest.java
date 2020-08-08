package com.glancebar.webfluxtutorial.mongo;

import com.glancebar.webfluxtutorial.entity.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class UserQueryTest {

    @Autowired
    private UserQuery userQuery;

    @BeforeEach
    void setUp() {
//        IntStream.range(1, 100).forEach(value -> {
//            User user = new User();
//            user.setUsername("User: " + value);
//            user.setNote("hello " + value);
//            User result = userQuery.saveUser(user);
//        });
    }

    @Test
    void getUser() {
        User user = userQuery.getUser("5f2e426d23a2892f53ddbb38");
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void findUsers() {
        List<User> users = userQuery.findUsers("User: 1", "hello 1", 0, 10);
        Assertions.assertEquals(1, users.size());
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername("username");
        user.setNote("hello");
        User result = userQuery.saveUser(user);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    void deleteUser() {
        DeleteResult result = userQuery.deleteUser("5f2e426d23a2892f53ddbb38");
        Assertions.assertEquals(result.getDeletedCount(), 1);
    }

    @Test
    void updateUser() {
        UpdateResult result = userQuery.updateUser("5f2e426d23a2892f53ddbb38", "yisen", null);
        Assertions.assertEquals(1, result.getModifiedCount());
    }

    @AfterEach
    void tearDown() {
//        IntStream.range(1, 100).forEach(value -> {
//
//        });
    }
}