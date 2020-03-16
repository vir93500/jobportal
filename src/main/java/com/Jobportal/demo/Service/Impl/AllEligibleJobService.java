package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Model.AppliedJobs;
import com.Jobportal.demo.Model.Job;
import com.Jobportal.demo.Response.AllEligibleJobResponse;
import com.Jobportal.demo.Service.IAllEligibleJobService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class AllEligibleJobService implements IAllEligibleJobService {

    @Override
    public List<AllEligibleJobResponse> findAllEligibleJob(List<AppliedJobs> appliedJobs, List<Job> fetchJobs) {
        Set<Object> set = new HashSet<Object>();

        if(appliedJobs.size()<fetchJobs.size()){
            for(Job job :fetchJobs){
                for (AppliedJobs appliedJobs1 :appliedJobs){
                    if(job.getCompanyName().equalsIgnoreCase(appliedJobs1.getCompanyName()) && appliedJobs1.getTimeStamp().isBefore(LocalDateTime.now().minusMonths(1))){
                        set.add(job);
                    }
                }
            }
        }
        Iterator<Object> i = set.iterator();
        while (i.hasNext())
            fetchJobs.remove(i.next());

        ModelMapper modelMapper = new ModelMapper();
        AllEligibleJobResponse allEligibleJobResponse;

        List<AllEligibleJobResponse> list = new ArrayList<>();
        for (Job job : fetchJobs){
            allEligibleJobResponse = modelMapper.map(job, AllEligibleJobResponse.class);
            list.add(allEligibleJobResponse);

        }

        return list;
    }
}
