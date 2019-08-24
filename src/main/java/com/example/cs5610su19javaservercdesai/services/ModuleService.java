package com.example.cs5610su19javaservercdesai.services;

import com.example.cs5610su19javaservercdesai.models.Lesson;
import com.example.cs5610su19javaservercdesai.models.Module;
import com.example.cs5610su19javaservercdesai.models.Topic;
import com.example.cs5610su19javaservercdesai.repositories.LessonRepository;
import com.example.cs5610su19javaservercdesai.repositories.ModuleRepository;
import com.example.cs5610su19javaservercdesai.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    public Module findModuleById(Integer moduleId){
        if(moduleRepository.findById(moduleId).isPresent()){
            return moduleRepository.findById(moduleId).get();
        }
        return null;
    }

    public Module saveModule(Module module){
        return moduleRepository.save(module);
    }

    public void deleteModule(Integer moduleId){
        moduleRepository.delete(findModuleById(moduleId));
    }

    public void createLessonForModule(Integer moduleId, Lesson lesson){
        Module module = findModuleById(moduleId);
        lesson.setModule(module);
        lessonRepository.save(lesson);
    }


}
