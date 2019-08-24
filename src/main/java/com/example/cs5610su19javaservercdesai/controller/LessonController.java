package com.example.cs5610su19javaservercdesai.controller;

import com.example.cs5610su19javaservercdesai.models.Lesson;
import com.example.cs5610su19javaservercdesai.services.LessonService;
import com.example.cs5610su19javaservercdesai.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LessonController {

    @Autowired
    ModuleService moduleService;
    @Autowired
    LessonService lessonService;

    @PostMapping("/api/modules/{mid}/lessons")
    public List<Lesson> createLessonForModule(@PathVariable("mid") Integer moduleId, @RequestBody Lesson lesson){
        moduleService.createLessonForModule(moduleId, lesson);
        return lessonService.findLessonsForModule(moduleId);
    }

    @GetMapping("/api/modules/{mid}/lessons")
    public List<Lesson> findLessonsForModule(@PathVariable("mid") Integer moduleId){
        return lessonService.findLessonsForModule(moduleId);
    }

    @GetMapping("/api/lessons/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Integer lessonId){
        return lessonService.findLessonById(lessonId);
    }

    @PutMapping("/api/lessons/{lid}")
    public Lesson updateLesson(@PathVariable("lid") Integer lessonId, @RequestBody Lesson newLesson){
        Lesson oldLesson = lessonService.findLessonById(lessonId);
        oldLesson.set(newLesson);
        return lessonService.saveLesson(oldLesson);
    }

    @DeleteMapping("/api/lessons/{lid}")
    public void deleteLesson(@PathVariable("lid") Integer lessonId){
        lessonService.deleteLesson(lessonId);
    }

}
