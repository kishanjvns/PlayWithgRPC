package com.tech.kj.controller;

import com.tech.kj.CourseRepository;
import com.tech.kj.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtoBuffController {
    @Autowired
    CourseRepository courseRepo;

    @RequestMapping("/courses/{id}")
    Training.Course customer(@PathVariable Integer id) {
        return courseRepo.getCourse(id);
    }
}
