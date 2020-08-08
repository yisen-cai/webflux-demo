package com.glancebar.webfluxtutorial.repository;

import com.glancebar.webfluxtutorial.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl {
    private final MongoTemplate mongoTemplate;

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<User> findByUsernameAndNote(String username, String note) {
        Criteria criteriaNote = Criteria.where("note").is(note);
        Criteria criteriaUsername = Criteria.where("username").is(username);
        Criteria criteria = new Criteria();
        criteria.andOperator(criteriaNote, criteriaUsername);
        Query query = Query.query(criteria);
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }

}
