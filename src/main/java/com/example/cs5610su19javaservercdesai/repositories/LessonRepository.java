package com.example.cs5610su19javaservercdesai.repositories;

import com.example.cs5610su19javaservercdesai.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    @Query("select lesson from Lesson lesson where lesson.module.id = :mid")
    List<Lesson> findAllLessonsForModule(@Param("mid") Integer moduleId);
}
