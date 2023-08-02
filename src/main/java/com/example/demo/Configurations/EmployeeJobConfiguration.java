package com.example.demo.Configurations;

import com.example.demo.Employee.Employee;
import com.example.demo.Employee.EmployeeRepository;
import com.example.demo.Job.Job;
import com.example.demo.Job.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo")
public class EmployeeJobConfiguration {
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    @Autowired
    public EmployeeJobConfiguration(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Bean
    CommandLineRunner jobCommandLiner(){
        return args -> {
            Job outSystemsDeveloper = new Job(
                    "OutSystems Developer",
                    "The primary role of the OutSystems Developer will be to design, build, test and deploy web and mobile applications using the LCAP/NCAP"
            );
            Job frontendDeveloper = new Job(
                    "Frontend Developer",
                    "Responsible for implementing visual elements that users see and interact with in a web application"
            );
            Job softwareEngineer = new Job(
                    "Software Engineer",
                    "An IT professional who designs, develops and maintains computer software at a company. They use their creativity and technical skills and apply the principles of software engineering to help solve new and ongoing problems for an organization."
            );
            Job uiuxDesigner = new Job(
                    "UI/UX Designer",
                    "UI UX designers create the user interface for an app, website, or other interactive media."
            );

            jobRepository.saveAll(
                    List.of(outSystemsDeveloper,frontendDeveloper,softwareEngineer,uiuxDesigner)
            );
        };
    }

    @Bean
    @Transactional
    CommandLineRunner employeeCommandLiner(){
        return args -> {
            // Fetch an existing Job using job_id from the Job table
            Job job = jobRepository.findById(1L).orElse(null);
            Job job2 = jobRepository.findById(2L).orElse(null);
            Job job3 = jobRepository.findById(3L).orElse(null);

            Employee leovyle = new Employee(
                    1L,
                    "Leovyle",
                    "Sarili",
                    LocalDate.of(1999, JULY, 24),
                    "Leo.Sarili@emapta.com",
                    job
            );

            Employee jred = new Employee(
                    2L,
                    "Jared",
                    "Santiago",
                    LocalDate.of(1999, OCTOBER, 05),
                    "Jred.Santiago@emapta.com",
                    job2
            );

            Employee glems = new Employee(
                    3L,
                    "Glems",
                    "Baterna",
                    LocalDate.of(1999, FEBRUARY, 25),
                    "Glems.Baterna@emapta.com",
                    job3
            );

            System.out.println(leovyle);
            System.out.println(jred);
            System.out.println(glems);
            employeeRepository.saveAll(
                    List.of(leovyle,jred,glems)
            );
        };
    }
}
