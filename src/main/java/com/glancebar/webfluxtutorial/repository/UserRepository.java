package com.glancebar.webfluxtutorial.repository;

import com.glancebar.webfluxtutorial.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findTopByUsernameEquals(String username);

    @Query("{'username': ?0}")
    Optional<User> findUserByMyOwn(String username);

    Optional<User> findByUsernameAndNote(String username, String note);
}
