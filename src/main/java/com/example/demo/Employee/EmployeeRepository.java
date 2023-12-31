package com.example.demo.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT emp FROM Employee emp WHERE emp.employee_email = ?1")
    Optional<Employee> findEmployeeByEmail(String employeeEmail);
}