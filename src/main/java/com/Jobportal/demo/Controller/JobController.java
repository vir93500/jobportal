package com.Jobportal.demo.Controller;

import com.Jobportal.demo.Model.AppliedJobs;
import com.Jobportal.demo.Model.Job;
import com.Jobportal.demo.Model.Registeration;
import com.Jobportal.demo.Model.User;
import com.Jobportal.demo.Repository.AppliedJobRepository;
import com.Jobportal.demo.Repository.JobRepository;
import com.Jobportal.demo.Repository.RegisterationRepository;
import com.Jobportal.demo.Repository.UserRepository;
import com.Jobportal.demo.Request.JobRequest;
import com.Jobportal.demo.Request.LoginUserRequest;
import com.Jobportal.demo.Request.RegisterationRequest;
//import com.Jobportal.demo.Request.SessionRequest;
import com.Jobportal.demo.Response.AllEligibleJobResponse;
import com.Jobportal.demo.Response.LoginUserResponse;
import com.Jobportal.demo.Service.IAllEligibleJobService;
import com.Jobportal.demo.Service.ILoginJobService;
//import com.Jobportal.demo.Service.ISessionToken;
import com.Jobportal.demo.Service.Impl.AllEligibleJobService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class JobController {

    @Autowired
    RegisterationRepository registerationRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    AppliedJobRepository appliedJobRepository;

    @Autowired
    IAllEligibleJobService iAllEligibleJobService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ILoginJobService iLoginJobService;

   /* @Autowired
    ISessionToken iSessionToken;*/

    @PostMapping(value = "/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registrationUser(@RequestBody RegisterationRequest request) throws Exception {
        try{
            List<Registeration> users = registerationRepository.findByUsername(request.getUsername());
            if(users.size()==0) {
                Registeration registeration = new Registeration(request.getUsername(), request.getFirstName(), request.getLasttName(), request.getPassword(), request.getEmailId(), request.getMobile(), request.getTotalWorkExp(),request.getId(),request.getAge());
                registerationRepository.save(registeration);
            }
            else
                return ResponseEntity.badRequest().build();
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getUserByUsername")
    public List<Registeration> getUserByUsername(@RequestParam(value = "username") String username) {
        List<Registeration> users = registerationRepository.findByUsername(username);
        System.out.println(users);
        return users;
    }

    @PostMapping(value = "/addNewJob")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addNewJob(@RequestBody JobRequest request) throws Exception {
        try {
            Job job = new Job(request.getCompanyName(), request.getLocation(), request.getJobProfile(), request.getExperienceRequired(), request.getSkillRequired(), request.getMinNoticePeriod(), request.getAlreadyAppliedInSixMonths(), request.getBlacklisted(), request.getAnyOffer());
            jobRepository.save(job);
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getAllAppliedJob")
    public List<AppliedJobs> fetchAppliedJobsByUsername(@RequestParam(value = "username") String username){
        List<AppliedJobs> appliedJobs = appliedJobRepository.findByUsername(username);
        System.out.println("appliedJobs"+appliedJobs);
        return appliedJobs;
    }

    @GetMapping(value = "/getAllEligibleJobs")
    public List<AllEligibleJobResponse> fetchJobsByUsername(@RequestParam(value = "username") String username) throws JsonProcessingException {
        List<AppliedJobs> appliedJobs = appliedJobRepository.findByUsername(username);
        List<Job> fetchJobs = jobRepository.findEligibleJobsByUsername();
        List<AllEligibleJobResponse> finalAllEligibleJob =  iAllEligibleJobService.findAllEligibleJob(appliedJobs,fetchJobs);
        return finalAllEligibleJob;
    }

    @PostMapping(value = "/loginUser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUserRequest request, @RequestHeader("Client-id") String clientId) throws Exception {
         final List<User> users = userRepository.ListUser();
         final LoginUserResponse loginUserResponse = iLoginJobService.loginUserStatus(users,request.getUsername(),request.getPassword(),clientId);
         if(loginUserResponse.getStatus()=="FAIL")
             return new ResponseEntity<LoginUserResponse>(loginUserResponse, HttpStatus.BAD_REQUEST);
         else
        return new ResponseEntity<LoginUserResponse>(loginUserResponse, HttpStatus.OK);
    }

    /*@PostMapping(value = "/addSessiontoken")
    @ResponseStatus(HttpStatus.OK)
    public boolean tokenSuccess(@RequestBody SessionRequest request) throws Exception {
        boolean result = iSessionToken.saveSessionToken(request.getToken(),request.getUsername());

      return result;
    }
*/

}
