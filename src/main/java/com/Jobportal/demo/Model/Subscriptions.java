package com.Jobportal.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Subscriptions")
public class Subscriptions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int subscriptionId;

    @Column(name = "subscriptionName")
    private String subscriptionName;

    @Column(name = "subscriptionValidity")
    private int subscriptionValidity;

    @Column(name = "totalJobsApply")
    private int totalJobsApply;

    public Subscriptions(){}

    public Subscriptions(String subscriptionName, int subscriptionValidity, int totalJobsApply, List<String> companies, String color, int price) {
        this.subscriptionName = subscriptionName;
        this.subscriptionValidity = subscriptionValidity;
        this.totalJobsApply = totalJobsApply;
        this.companies = companies;
        this.color = color;
        this.price = price;
    }

    @Column(name = "companies")
    @ElementCollection(targetClass=String.class)
    private List<String> companies;

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public int getSubscriptionValidity() {
        return subscriptionValidity;
    }

    public void setSubscriptionValidity(int subscriptionValidity) {
        this.subscriptionValidity = subscriptionValidity;
    }

    public int getTotalJobsApply() {
        return totalJobsApply;
    }

    public void setTotalJobsApply(int totalJobsApply) {
        this.totalJobsApply = totalJobsApply;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;
}