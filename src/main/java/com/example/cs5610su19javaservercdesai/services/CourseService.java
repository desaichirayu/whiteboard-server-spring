package com.example.cs5610su19javaservercdesai.services;

import com.example.cs5610su19javaservercdesai.models.Course;
import com.example.cs5610su19javaservercdesai.models.Module;
import com.example.cs5610su19javaservercdesai.repositories.CourseRepository;
import com.example.cs5610su19javaservercdesai.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> findAllCourses(){
        return (List<Course>)courseRepository.findAll();
    }

    public Course findCourseById(Integer courseId){
        if(courseRepository.findById(courseId).isPresent()){
            return courseRepository.findById(courseId).get();
        }
        return null;
    }

    public void deleteCourse(Integer courseId){
        courseRepository.delete(findCourseById(courseId));
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public void createModuleForCourse(Integer courseId, Module module){
        Course course = findCourseById(courseId);
        module.setCourse(course);
        moduleRepository.save(module);
    }

    public List<Module> findAllModulesForCourse(Integer courseId){
        return moduleRepository.findAllModulesForCourse(courseId);
    }

}
