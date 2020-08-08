package com.glancebar.webfluxtutorial.mongo;

import com.glancebar.webfluxtutorial.entity.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuery {

    private final MongoTemplate mongoTemplate;

    public UserQuery(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public User getUser(String id) {
//        Criteria criteriaId = Criteria.where("id").is(id);
//        Query queryId = Query.query(criteriaId);
//        return mongoTemplate.findOne(queryId, User.class);
        return mongoTemplate.findById(id, User.class);
    }

    public List<User> findUsers(String username, String note, int skip, int limit) {
        Criteria criteria = Criteria.where("username").is(username).and("note").is(note);
        Query query = Query.query(criteria).limit(limit).skip(skip);
        return mongoTemplate.find(query, User.class);
    }


    public User saveUser(User user) {
        mongoTemplate.save(user, "user");
        return mongoTemplate.save(user);
    }

    public DeleteResult deleteUser(String id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);
        DeleteResult result = mongoTemplate.remove(query, User.class);
        return result;
    }


    public UpdateResult updateUser(String id, String username, String note) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);
        Update update = Update.update("username", username);
        update.set("note", note);
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
//        UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);
        return result;
    }


}
