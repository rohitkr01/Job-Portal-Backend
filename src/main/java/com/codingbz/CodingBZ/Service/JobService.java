package com.codingbz.CodingBZ.Service;

import com.codingbz.CodingBZ.DTOs.JobDTO;
import com.codingbz.CodingBZ.Model.Job;
import com.codingbz.CodingBZ.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

//    public void createJob(JobDTO jobDTO) {
//        Job job = new Job();
//        job.setJobRole(jobDTO.getJobRole());
//        job.setCompanyName(jobDTO.getCompanyName());
//        job.setLocation(jobDTO.getLocation());
//        job.setVacancies(jobDTO.getVacancies());
//        job.setSalary(jobDTO.getSalary());
//        jobRepository.save(job);
//    }

    public void createJob(Job job) {
        jobRepository.save(job);
    }

    public Job updateJob(JobDTO updatedJob){
        Long jobId = updatedJob.getId();
        Job existingJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found with ID: " + jobId));

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobRole(updatedJob.getJobRole());
        existingJob.setJobDescription(updatedJob.getJobDescription());
        existingJob.setLocation(updatedJob.getLocation());

        existingJob.setSkills(updatedJob.getSkills());
        existingJob.setVacancies(updatedJob.getVacancies());
        existingJob.setSalary(updatedJob.getSalary());
        jobRepository.save(existingJob);

        return jobRepository.save(existingJob);
    }

    public Job getJobById(Long id){
        List<Job> jobList = jobRepository.findAll().stream()
                .filter(job -> ( job.getId() == id )).collect(Collectors.toList());
        Job job = jobList.get(0);

        return job;
    }

    public List<Job> getAllJob(){
        List<Job> jobs = jobRepository.findAll();
        return jobs;
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

}
