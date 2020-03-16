package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.AppliedJobs;
import com.Jobportal.demo.Model.Job;
import com.Jobportal.demo.Response.AllEligibleJobResponse;

import java.util.List;

public interface IAllEligibleJobService {
    List<AllEligibleJobResponse> findAllEligibleJob(List<AppliedJobs> appliedJobs, List<Job> fetchJobs);
}
