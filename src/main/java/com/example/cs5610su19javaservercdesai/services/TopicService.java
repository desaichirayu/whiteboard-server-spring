package com.example.cs5610su19javaservercdesai.services;

import com.example.cs5610su19javaservercdesai.models.Topic;
import com.example.cs5610su19javaservercdesai.models.Widget;
import com.example.cs5610su19javaservercdesai.repositories.TopicRepository;
import com.example.cs5610su19javaservercdesai.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public Topic findTopicById(Integer topicId){
        if(topicRepository.findById(topicId).isPresent()){
            return topicRepository.findById(topicId).get();
        }
        return null;
    }

    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer topicId){
        topicRepository.delete(findTopicById(topicId));
    }

    public void createWidget(Integer topicId, Widget widget){
        Topic topic = findTopicById(topicId);
        widget.setTopic(topic);
        widgetRepository.save(widget);
    }

    public List<Widget> findAllWidgets(Integer topicId){
        return widgetRepository.findAllWidgetsForTopic(topicId);
    }

    public void saveWidgets(Integer topicId, List<Widget> newWidgets){
        Topic topic = findTopicById(topicId);
        List<Widget> oldWidgets = findAllWidgets(topicId);
        for (Widget w: oldWidgets) {
            widgetRepository.delete(w);
        }
        for (Widget w: newWidgets) {
            w.setTopic(topic);
            widgetRepository.save(w);
        }
    }

    public List<Topic> findTopicsForLesson(Integer lessonId){
        return topicRepository.findAllTopicsForLesson(lessonId);
    }
}
