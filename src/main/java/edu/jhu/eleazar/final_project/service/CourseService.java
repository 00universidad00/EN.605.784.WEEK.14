package edu.jhu.eleazar.final_project.service;

import edu.jhu.eleazar.final_project.model.Course;

import java.util.Collection;
import java.util.Optional;

public interface CourseService {
    void addCourse(Course course);

    Optional<Course> getCourseById(String id);

    Collection<Course> getAllCourses();
}
