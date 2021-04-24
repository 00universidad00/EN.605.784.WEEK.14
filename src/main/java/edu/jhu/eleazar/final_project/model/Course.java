package edu.jhu.eleazar.final_project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "COURSES")
public class Course implements Serializable {
    @Id
    private String id;
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> students;
}
