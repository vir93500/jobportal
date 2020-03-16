package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query(value = "SELECT * FROM eligiblejobtable", nativeQuery = true)
    List<Job> findEligibleJobsByUsername();

   /* @Query(value = "SELECT * FROM eligiblejobtable ", nativeQuery = true)
    List<Job> findEligibleJobs();*/



}
