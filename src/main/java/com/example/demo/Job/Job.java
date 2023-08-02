package com.example.demo.Job;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Long job_id;
    private String job_name;
    private String job_description;

    public Job() {
    }

    public Job(Long job_id, String job_name, String job_description) {
        this.job_id = job_id;
        this.job_name = job_name;
        this.job_description = job_description;
    }

    public Job(String job_name, String job_description) {
        this.job_name = job_name;
        this.job_description = job_description;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                ", job_description='" + job_description + '\'' +
                '}';
    }
}
