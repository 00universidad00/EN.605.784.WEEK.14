package edu.jhu.eleazar.final_project.controller;

import edu.jhu.eleazar.final_project.exception.StudentNotFoundException;
import edu.jhu.eleazar.final_project.model.Student;
import edu.jhu.eleazar.final_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/students/")
public class StudentServiceController {

    @Autowired
    StudentService studentService;

    @GetMapping("get/all")
    public ResponseEntity<Object> getStudents() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Student> get(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id).orElseThrow(() -> new StudentNotFoundException(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
}
