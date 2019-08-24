package com.example.cs5610su19javaservercdesai.repositories;

import com.example.cs5610su19javaservercdesai.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

    @Query("select module from Module module where module.course.id = :cid")
    List<Module> findAllModulesForCourse(@Param("cid") Integer courseId);
}
