package com.example.demo.Job;

import com.example.demo.Employee.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long jobId) {
        // Use the findById() method to get the Job by its primary key (jobId)
        return jobRepository.findById(jobId).orElse(null);
    }

    @Transactional
    public void updateJob(Long jobId, String jobName) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new IllegalStateException(
                "job with id " + jobId + " does not exist"
        ));

        if(jobName !=null && jobName.length() > 0 && !Objects.equals(job.getJob_name(),jobName)){
            job.setJob_name(jobName);
        }
    }

    public void deleteJob(Long jobId) {
        boolean exists = jobRepository.existsById(jobId);
        if (!exists){
            throw new IllegalStateException("Job with id " + jobId + " does not exists");
        }

        jobRepository.deleteById(jobId);
    }
}
