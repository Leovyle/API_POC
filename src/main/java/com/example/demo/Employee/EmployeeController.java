package com.example.demo.Employee;

import com.example.demo.Job.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
//    CREATE MULTIPLE THROUGH POSTMAN
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployees")
    public ResponseEntity<String> addEmployees(@RequestBody List<Employee> employeeData){
        employeeRepository.saveAll(employeeData);
        return ResponseEntity.ok("Data saved");
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

//  READ
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

//    UPDATE
    @PutMapping(path = "{employeeId}")
    public void UpdateEmployee(@PathVariable("employeeId") Long employeeId, @RequestParam(required=false) String firstName, @RequestParam(required=false) String employeeEmail){
        employeeService.updateEmployee(employeeId,firstName,employeeEmail);
    }
//    DELETE
    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
