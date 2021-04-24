package edu.jhu.eleazar.final_project.exception;

public class CourseNotAvailable extends RuntimeException {

    public CourseNotAvailable(String exception) {
        super("This course is either full or the user is already registered for: " + exception);
    }
}