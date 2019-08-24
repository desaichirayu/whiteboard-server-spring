package com.example.cs5610su19javaservercdesai.services;

import com.example.cs5610su19javaservercdesai.models.Lesson;
import com.example.cs5610su19javaservercdesai.models.Topic;
import com.example.cs5610su19javaservercdesai.models.Widget;
import com.example.cs5610su19javaservercdesai.repositories.LessonRepository;
import com.example.cs5610su19javaservercdesai.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    TopicRepository topicRepository;

    public Lesson findLessonById(Integer lessonId){
        if(lessonRepository.findById(lessonId).isPresent()){
            return lessonRepository.findById(lessonId).get();
        }
        return null;
    }

    public Lesson saveLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Integer lessonId){
        lessonRepository.delete(findLessonById(lessonId));
    }

    public void createTopicForLesson(Integer lessonId, Topic topic){
        Lesson lesson = findLessonById(lessonId);
        topic.setLesson(lesson);
        topicRepository.save(topic);
    }

    public List<Lesson> findLessonsForModule(Integer moduleId){
        return lessonRepository.findAllLessonsForModule(moduleId);
    }
}
