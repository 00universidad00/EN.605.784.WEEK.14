package edu.jhu.eleazar.final_project;

import edu.jhu.eleazar.final_project.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectApplication {

    @Autowired
    DatabaseService databaseService; // populate db with test data

    // app starts here
    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

}
