package com.example.repository;

import com.example.model.Topic;

public interface TopicRepository {

    void saveTopic(Topic topic);

    Topic findTopicByTitle(String title);

    long updateTopic(Topic topic);

    void deleteTopicById(String id);

}
