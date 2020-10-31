package com.sadman.springrest.configuration;

import com.sadman.springrest.model.Employee;
import com.sadman.springrest.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sadman
 */
@Configuration
class LoadDatabase {

//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(EmployeeRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Employee("Sadman", "Sobhan", "imran@gmail.com")));
//            log.info("Preloading " + repository.save(new Employee("John", "Doe", "john@gmail.com")));
//        };
//    }
}
