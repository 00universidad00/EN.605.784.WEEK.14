package edu.jhu.eleazar.final_project.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String exception) {
        super("Course does not exist im DB: " + exception);
    }

}