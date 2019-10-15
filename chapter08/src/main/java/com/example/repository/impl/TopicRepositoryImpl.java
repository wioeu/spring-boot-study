package com.example.repository.impl;

import com.example.model.Topic;
import com.example.repository.TopicRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class TopicRepositoryImpl implements TopicRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveTopic(Topic topic) {
        mongoTemplate.save(topic);
    }

    @Override
    public Topic findTopicByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        Topic topic = mongoTemplate.findOne(query,Topic.class);
        return topic;
    }

    @Override
    public long updateTopic(Topic topic) {
        Query query = new Query(Criteria.where("id").is(topic.getId()));
        Update update = new Update()
                .set("name",topic.getName())
                .set("title",topic.getTitle())
                .set("content",topic.getContent())
                .set("time",topic.getTime());

        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,Topic.class);
        if(updateResult!=null){
            return updateResult.getMatchedCount();
        }
        return 0;
    }

    @Override
    public void deleteTopicById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Topic.class);
    }
}
