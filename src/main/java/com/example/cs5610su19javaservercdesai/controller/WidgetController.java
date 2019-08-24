package com.example.cs5610su19javaservercdesai.controller;

import com.example.cs5610su19javaservercdesai.models.Widget;
import com.example.cs5610su19javaservercdesai.services.TopicService;
import com.example.cs5610su19javaservercdesai.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {

    @Autowired
    TopicService topicService;
    @Autowired
    WidgetService widgetService;


    @PostMapping("/api/topics/{tid}/widgets")
    public List<Widget> createWidget(@PathVariable("tid") Integer topicId, @RequestBody Widget widget){
        topicService.createWidget(topicId, widget);
        return topicService.findAllWidgets(topicId);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer topicId){
        return widgetService.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer widgetId){
        return widgetService.findWidgetById(widgetId);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(@PathVariable("wid") Integer widgetId){
        widgetService.deleteWidget(widgetId);
    }

    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget newWidget){
        Widget oldWidget = widgetService.findWidgetById(widgetId);
        oldWidget.set(newWidget);
        return widgetService.saveWidget(oldWidget);
    }

    @PutMapping("/api/topics/{tid}/widgets")
    public List<Widget> saveWidgets(@PathVariable("tid") Integer topicId, @RequestBody List<Widget> widgets){
        topicService.saveWidgets(topicId, widgets);
        return topicService.findAllWidgets(topicId);
    }
}
