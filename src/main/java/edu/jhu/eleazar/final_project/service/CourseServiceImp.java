package edu.jhu.eleazar.final_project.service;

import edu.jhu.eleazar.final_project.model.Course;
import edu.jhu.eleazar.final_project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    @Override
    public Collection<Course> getAllCourses() {
        return new ArrayList<>(((List<Course>) courseRepository.findAll()));
    }
}
