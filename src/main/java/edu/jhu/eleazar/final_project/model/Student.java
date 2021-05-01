package edu.jhu.eleazar.final_project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "STUDENT")
public class Student implements Serializable {
    @Id
    private String id;
    private String first;
    private String last;
    private String dob;
    private String address;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "REGISTRAR",
            joinColumns = @JoinColumn(name = "Number_Registered"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID")
    )
    private Set<Course> courses;

    public void registerForCourse(Course course) {
        this.getCourses().add(course);
    }
}
