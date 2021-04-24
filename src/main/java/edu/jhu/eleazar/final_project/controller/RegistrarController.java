package edu.jhu.eleazar.final_project.controller;

import edu.jhu.eleazar.final_project.exception.CourseNotAvailable;
import edu.jhu.eleazar.final_project.exception.CourseNotFoundException;
import edu.jhu.eleazar.final_project.exception.StudentNotFoundException;
import edu.jhu.eleazar.final_project.model.Course;
import edu.jhu.eleazar.final_project.model.Student;
import edu.jhu.eleazar.final_project.service.CourseService;
import edu.jhu.eleazar.final_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(value = "/api/registrar/")
@PropertySource("classpath:application.properties")
public class RegistrarController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Value("${max.course.capacity}")
    private int MAX_COURSE_CAPACITY;

    @PostMapping("add/{student_id}/to/{course_id}")
    public ResponseEntity<Student> addStudentToCourse(@PathVariable String student_id, @PathVariable String course_id) {

        // get student form db
        Student student = studentService.getStudentById(student_id)
                .orElseThrow(() -> new StudentNotFoundException(student_id));

        // get course form db
        Course course = courseService.getCourseById(course_id)
                .orElseThrow(() -> new CourseNotFoundException(course_id));

        // check if user is already registered for class
        if (student.getCourses().stream().anyMatch(course::equals))
            throw new CourseNotAvailable(course_id);

        // check if course is full
        if (course.getStudents().size() >= MAX_COURSE_CAPACITY)
            throw new CourseNotAvailable(course_id);

        // register student
        student.registerForCourse(course);

        // save student in db
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
}
