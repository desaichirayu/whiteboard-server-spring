package com.example.cs5610su19javaservercdesai.controller;

import com.example.cs5610su19javaservercdesai.models.Topic;
import com.example.cs5610su19javaservercdesai.services.LessonService;
import com.example.cs5610su19javaservercdesai.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TopicController {

    @Autowired
    LessonService lessonService;

    @Autowired
    TopicService topicService;

    @PostMapping("/api/lessons/{lid}/topics")
    public List<Topic> createTopicForLesson(@PathVariable("lid") Integer lessonId, @RequestBody Topic topic){
        lessonService.createTopicForLesson(lessonId, topic);
        return topicService.findTopicsForLesson(lessonId);
    }

    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lid") Integer lessonId){
        return topicService.findTopicsForLesson(lessonId);
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer topicId){
        return topicService.findTopicById(topicId);
    }

    @PutMapping("/api/topics/{tid}")
    public Topic updateTopic(@PathVariable("tid") Integer topicId, @RequestBody Topic newTopic){
        Topic oldTopic = topicService.findTopicById(topicId);
        oldTopic.set(newTopic);
        return topicService.saveTopic(oldTopic);
    }

    @DeleteMapping("/api/topics/{tid}")
    public void deleteTopic(@PathVariable("tid") Integer topicId){
        topicService.deleteTopic(topicId);
    }

}
