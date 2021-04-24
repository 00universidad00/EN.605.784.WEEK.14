package edu.jhu.eleazar.final_project.repository;

import edu.jhu.eleazar.final_project.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
