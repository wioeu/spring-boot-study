package com.example.controller;

import com.example.model.Topic;
import com.example.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongodb")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @PostMapping("saveTopic")
    public Topic saveTopic(@RequestBody Topic topic){
        topicRepository.saveTopic(topic);
        return topic;
    }

    @PostMapping("findTopicByTitle")
    public Topic findTopicByTitle(@RequestBody Topic topic){
        topic = topicRepository.findTopicByTitle(topic.getTitle());
        return topic;
    }

    @PostMapping("updateTopic")
    public long updateTopic(@RequestBody Topic topic){
        return topicRepository.updateTopic(topic);
    }

    @PostMapping("deleteTopicById")
    public String deleteTopicById(@RequestBody Topic topic){
        topicRepository.deleteTopicById(topic.getId());
        return topic.getId();
    }

}
