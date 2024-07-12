package com.example.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class jobController {

    private JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll() , HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully" , HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        Boolean Deleted = jobService.deleteJobById(id);
        if(Deleted){
            return new ResponseEntity<>("Job Deleted Successfully" , HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>("Job Not Found" , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id ,@RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated Successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not Found" , HttpStatus.NOT_FOUND);
    }
}
