package com.example.cs5610su19javaservercdesai.repositories;

import com.example.cs5610su19javaservercdesai.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("select topic from Topic topic where topic.lesson.id = :lid")
    List<Topic> findAllTopicsForLesson(@Param("lid") Integer lessonId);
}
