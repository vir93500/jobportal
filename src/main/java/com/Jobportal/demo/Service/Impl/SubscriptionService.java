package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Repository.SubscriptionRepository;
import com.Jobportal.demo.Service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public String findSubscriptions(String subscriptionName) {
        return subscriptionRepository.getSubscriptionByName(subscriptionName);
    }
}
