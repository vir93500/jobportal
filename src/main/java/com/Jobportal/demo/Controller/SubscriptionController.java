package com.Jobportal.demo.Controller;

import com.Jobportal.demo.Exception.SubscriptionAlreadyExistException;
import com.Jobportal.demo.Model.Subscriptions;
import com.Jobportal.demo.Repository.SubscriptionRepository;
import com.Jobportal.demo.Request.SubscriptionCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @PostMapping(value = "/addSubscription")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addSubscription(@RequestBody SubscriptionCreationRequest request) throws Exception {
            System.out.println("subss"+request.getSubscriptionName());

            String subsname = subscriptionRepository.getSubscriptionByName(request.getSubscriptionName());
            if(subsname==null) {
                Subscriptions subscriptions = new Subscriptions(request.getSubscriptionName(), request.getSubscriptionValidity(), request.getTotalJobsApply(), request.getCompanies(), request.getColor(), request.getPrice());
                subscriptionRepository.save(subscriptions);
            }
            else
                throw new SubscriptionAlreadyExistException();
        return ResponseEntity.ok().build();
    }
}
