package com.example.firstjobapp.job.Impl;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobRepository;
import com.example.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //public List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(@RequestBody Job job) {
        jobRepository.save(job);
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    @Override
    public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            return true;
        }
        return false;
    }
}

