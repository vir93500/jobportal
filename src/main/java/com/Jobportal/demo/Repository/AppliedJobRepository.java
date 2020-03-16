package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.AppliedJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppliedJobRepository extends JpaRepository<AppliedJobs,Integer> {

    @Query(value = "SELECT * FROM appliedjob b WHERE b.username = :username", nativeQuery = true)
    List<AppliedJobs> findByUsername(String username);

}
