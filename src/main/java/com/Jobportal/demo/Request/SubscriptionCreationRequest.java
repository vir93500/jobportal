package com.Jobportal.demo.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionCreationRequest {

    private String subscriptionName;

    private int subscriptionValidity;

    private int totalJobsApply;

    private List<String> companies;

    private String color;

    private int price;
}
