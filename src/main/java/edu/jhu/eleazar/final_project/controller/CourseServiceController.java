package edu.jhu.eleazar.final_project.controller;

import edu.jhu.eleazar.final_project.exception.CourseNotFoundException;
import edu.jhu.eleazar.final_project.model.Course;
import edu.jhu.eleazar.final_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/courses/")
public class CourseServiceController {

    @Autowired
    CourseService courseService;

    @GetMapping("get/all")
    public ResponseEntity<Object> getCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public Course getCourse(@PathVariable String id) {

        // get course form db
        return courseService.getCourseById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
}