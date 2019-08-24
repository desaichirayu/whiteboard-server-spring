package com.example.cs5610su19javaservercdesai.controller;

import com.example.cs5610su19javaservercdesai.models.Course;
import com.example.cs5610su19javaservercdesai.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses(){
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Integer courseId){
        return courseService.findCourseById(courseId);
    }

    @PostMapping("/api/courses")
    public List<Course> createCourse(@RequestBody Course course){
        courseService.createCourse(course);
        return courseService.findAllCourses();
    }

    @PutMapping("/api/courses/{courseId}")
    public Course updateCourse(@PathVariable("courseId") Integer courseId, @RequestBody Course newCourse){
        Course oldCourse = findCourseById(courseId);
        oldCourse.set(newCourse);
        return courseService.saveCourse(oldCourse);
    }

    @DeleteMapping("/api/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer courseId){
        courseService.deleteCourse(courseId);
    }
}
