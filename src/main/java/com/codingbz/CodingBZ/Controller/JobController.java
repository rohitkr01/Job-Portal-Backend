package com.codingbz.CodingBZ.Controller;

import com.codingbz.CodingBZ.DTOs.JobDTO;
import com.codingbz.CodingBZ.Model.Job;
import com.codingbz.CodingBZ.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with the actual React application URL
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobService jobService;


    @PostMapping("/post-job")
    public ResponseEntity<?> createJob(@RequestBody Job job) {
        try {
            jobService.createJob(job);
            return ResponseEntity.ok("Job Created Successfully !");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateJob(@RequestBody JobDTO jobDTO){
        try{
            Job response = jobService.updateJob(jobDTO);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getJob/{id}")
    public ResponseEntity<?> getJobById(@PathVariable Long id){
        try{
        Job response = jobService.getJobById(id);
        return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("delete_job/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable Long id){
        try {
            jobService.deleteJobById(id);
            return ResponseEntity.ok("Job Deleted sucessfully !");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/all-jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> response = jobService.getAllJob();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

}
