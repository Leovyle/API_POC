package com.example.demo.Employee;

import com.example.demo.Job.Job;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long employee_id;
    private String first_name;
    private String last_name;
    private LocalDate date_of_birth;
    private String employee_email;
    @Transient
    private Integer Age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_job_id", referencedColumnName = "job_id")
    private Job job;

    public Employee() {
    }

    public Employee(Long employee_id, String first_name, String last_name, LocalDate date_of_birth, String employee_email, Job job) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.employee_email = employee_email;
        this.job = job;
    }

    public Employee(String first_name, String last_name, LocalDate date_of_birth, String employee_email, Job job) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.employee_email = employee_email;
        this.job = job;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public Integer getAge() {
        return Period.between(this.date_of_birth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", employee_email='" + employee_email + '\'' +
                ", Age=" + Age +
                ", job=" + job +
                '}';
    }
}
