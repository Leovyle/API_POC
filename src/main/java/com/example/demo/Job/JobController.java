package com.example.demo.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/job")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }
//  Create
//  Read
    @GetMapping
    public List<Job> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping(path = "{JobId}")
    public void getJobs(@PathVariable("JobId") Long jobId){
        System.out.println(jobService.getJobById(jobId));
    }
//    UPDATE
    @PutMapping(path = "{jobId}")
    public void UpdateJob(@PathVariable("jobId") Long jobId, @RequestParam(required=false) String jobName){
        jobService.updateJob(jobId,jobName);
    }
//    DELETE
    @DeleteMapping(path = "{jobId}")
    public void deleteJob(@PathVariable("jobId") Long jobId){
        jobService.deleteJob(jobId);
    }

}
