package com.sadman.springrest.repository;

import com.sadman.springrest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sadman
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
