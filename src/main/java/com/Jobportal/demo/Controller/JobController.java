package com.Jobportal.demo.Controller;

import com.Jobportal.demo.Exception.ReallyNeedException.InternalServerErrorException;
import com.Jobportal.demo.Exception.UserAlreadyExistException;
import com.Jobportal.demo.Exception.UserNotFoundException;
import com.Jobportal.demo.Model.*;
import com.Jobportal.demo.Repository.*;
import com.Jobportal.demo.Request.JobRequest;
import com.Jobportal.demo.Request.LoginUserRequest;
import com.Jobportal.demo.Request.RegisterationRequest;
import com.Jobportal.demo.Model.SessionIds;
import com.Jobportal.demo.Request.SubscriptionCreationRequest;
import com.Jobportal.demo.Response.AllEligibleJobResponse;
import com.Jobportal.demo.Response.LoginUserResponse;
import com.Jobportal.demo.Service.IAllEligibleJobService;
import com.Jobportal.demo.Service.ILoginJobService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    SessionTokenRepository iSessionToken;

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
                throw new UserAlreadyExistException();
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new InternalServerErrorException();
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
    public ResponseEntity<Object> addNewJob(@RequestBody JobRequest request){
        try {
            Job job = new Job(request.getCompanyName(), request.getLocation(), request.getJobProfile(), request.getExperienceRequired(), request.getSkillRequired(), request.getMinNoticePeriod(), request.getAlreadyAppliedInSixMonths(), request.getBlacklisted(), request.getAnyOffer());
            jobRepository.save(job);
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new InternalServerErrorException();
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
             throw new UserNotFoundException();
         else
        return new ResponseEntity<LoginUserResponse>(loginUserResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/createSessiontoken")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createSessionToken(@RequestBody SessionIds request) throws Exception {
        SessionIds sessionIds = new SessionIds(request.getToken(),request.getUsername());
         iSessionToken.save(sessionIds);
      return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getSessiontoken")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createSessionToken(@RequestParam (value = "username") String username) throws Exception {
        String result = iSessionToken.findSessionTokenDb(username);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }


}
