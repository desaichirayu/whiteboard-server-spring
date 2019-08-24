package com.example.cs5610su19javaservercdesai.repositories;

import com.example.cs5610su19javaservercdesai.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{

    @Query("select widget from Widget widget where widget.topic.id = :tid")
    List<Widget> findAllWidgetsForTopic(@Param("tid") Integer topicId);

}
