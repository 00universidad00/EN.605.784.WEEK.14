package edu.jhu.eleazar.final_project.service;

import edu.jhu.eleazar.final_project.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);

    Collection<Student> getAll();

    Optional<Student> getStudentById(String id);
}
