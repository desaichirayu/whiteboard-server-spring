package com.example.cs5610su19javaservercdesai.controller;

import com.example.cs5610su19javaservercdesai.models.Module;
import com.example.cs5610su19javaservercdesai.services.CourseService;
import com.example.cs5610su19javaservercdesai.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ModuleController {

    @Autowired
    CourseService courseService;
    @Autowired
    ModuleService moduleService;

    @PostMapping("/api/courses/{courseId}/modules")
    public List<Module> createModuleForCourse(@PathVariable("courseId") Integer courseId, @RequestBody Module module){
        courseService.createModuleForCourse(courseId, module);
        return courseService.findAllModulesForCourse(courseId);
    }

    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findAllModulesForCourse(@PathVariable("courseId") Integer courseId){
        return courseService.findAllModulesForCourse(courseId);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer moduleId){
        return moduleService.findModuleById(moduleId);
    }

    @PutMapping("/api/modules/{mid}")
    public Module updateModule(@PathVariable("mid") Integer moduleId, @RequestBody Module newModule){
        Module oldModule = moduleService.findModuleById(moduleId);
        oldModule.set(newModule);
        return moduleService.saveModule(oldModule);
    }

    @DeleteMapping("/api/modules/{mid}")
    public void deleteModule(@PathVariable("mid") Integer moduleId){
        moduleService.deleteModule(moduleId);
    }

}
