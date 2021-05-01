package edu.jhu.eleazar.final_project.service;

import edu.jhu.eleazar.final_project.model.Course;
import edu.jhu.eleazar.final_project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @PostConstruct
    public void init() {
        populateStudentTable();
        populateCourseTable();
        populateRegistrarTable();
    }

    private void populateCourseTable() {
        Course course1 = new Course();
        course1.setId("605.784");
        course1.setName("Enterprise Computing with Java");
        courseService.addCourse(course1);

        Course course2 = new Course();
        course2.setId("605.785");
        course2.setName("Web Services");
        courseService.addCourse(course2);

        Course course3 = new Course();
        course3.setId("605.786");
        course3.setName("Enterprise System Design and Implementation");
        courseService.addCourse(course3);

        Course course4 = new Course();
        course4.setId("605.787");
        course4.setName("Rich Internet Applications with Ajax");
        courseService.addCourse(course4);

        Course course5 = new Course();
        course5.setId("605.788");
        course5.setName("Big Data Processing Using Hadoop");
        courseService.addCourse(course5);
    }

    private void populateStudentTable() {
        // create user Romeo
        Student romeo = new Student();
        romeo.setId("admin");
        romeo.setFirst("Romeo");
        romeo.setLast("Montagues");
        romeo.setDob("01/01/1988");
        romeo.setAddress("1st Street, Sierra Vista, AZ, 85625");
        // add Romeo to DB
        studentService.addStudent(romeo);

        // Create user Juliet
        Student juliet = new Student();
        juliet.setId("juliet1234");
        juliet.setFirst("Juliet");
        juliet.setLast("Capulets");
        juliet.setDob("1991-04-17");
        juliet.setAddress("1st Street, San Juan, PR, 00957");
        // add juliet to DB
        studentService.addStudent(juliet);
    }

    private void populateRegistrarTable() {
        //get courses
        Course course2 = courseService.getCourseById("605.785").orElse(null);
        Course course4 = courseService.getCourseById("605.787").orElse(null);
        // get student
        Optional<Student> romeo = studentService.getStudentById("admin");
        // register for class and save student to db
        if (romeo.isPresent()) {
            romeo.get().registerForCourse(course2);
            romeo.get().registerForCourse(course4);
            studentService.addStudent(romeo.get());
        }
    }
}