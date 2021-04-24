package edu.jhu.eleazar.final_project.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String exception) {
        super("Student does not exist in DB: " + exception);
    }

}