package com.example.cs5610su19javaservercdesai.services;

import com.example.cs5610su19javaservercdesai.models.Widget;
import com.example.cs5610su19javaservercdesai.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public Widget findWidgetById(Integer widgetId){
        if(widgetRepository.findById(widgetId).isPresent()){
            return widgetRepository.findById(widgetId).get();
        }
        return null;
    }

    public void deleteWidget(Integer widgetId){
        widgetRepository.delete(findWidgetById(widgetId));
    }

    public Widget saveWidget(Widget widget){
        return widgetRepository.save(widget);
    }

    public List<Widget> findWidgetsForTopic(Integer topicId){
        return widgetRepository.findAllWidgetsForTopic(topicId);
    }

}
