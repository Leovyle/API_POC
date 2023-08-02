package com.example.demo.Employee;

import com.example.demo.Job.Job;
import com.example.demo.Job.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional= employeeRepository.findEmployeeByEmail(employee.getEmployee_email());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String firstName, String employeeEmail) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException(
                "employee with id " + employeeId + " does not exist"
        ));

        if(firstName !=null && firstName.length() > 0 && !Objects.equals(employee.getFirst_name(),firstName)){
            employee.setFirst_name(firstName);
        }

        if (employeeEmail != null && employeeEmail.length() > 0 && !Objects.equals(employee.getEmployee_email(),employeeEmail)){
            Optional<Employee> employeeOptional= employeeRepository.findEmployeeByEmail(employeeEmail);
            if (employeeOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            employee.setEmployee_email(employeeEmail);
        }
    }

    public void deleteEmployee(Long employeeId) {
            boolean exists = employeeRepository.existsById(employeeId);
            if (!exists){
                throw new IllegalStateException("Employee with id " + employeeId + " does not exists");
            }

            employeeRepository.deleteById(employeeId);
    }
}
