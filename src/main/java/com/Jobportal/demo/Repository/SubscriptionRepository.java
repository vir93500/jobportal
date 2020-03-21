package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionRepository extends JpaRepository<Subscriptions,Integer> {

    @Query(value = "SELECT s.subscription_Name FROM subscriptions s WHERE s.subscription_Name = :subsName", nativeQuery = true)
    public String getSubscriptionByName(String subsName);
}