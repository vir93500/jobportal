package com.Jobportal.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "eligiblejobtable")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Jobid")
    private int jobId;

    @Column(name="Companyname",nullable=true)
    @JsonProperty
    private String companyName;

    @Column(name="Location",nullable=true)
    @JsonProperty
    private String location;

    @Column(name="Jobprofile",nullable=true)
    @JsonProperty
    private String jobProfile;

    @Column(name="Experiencerequired",nullable=true)
    @JsonProperty
    private int experienceRequired;

    @Column(name="Skillsrequired",nullable=true)
    @JsonProperty
    private String skillRequired;

    @Column(name="Minnoticeperiod",nullable=true)
    @JsonProperty
    private int minNoticePeriod;

    @Column(name="Alreadyappliedinsixmonths",nullable=true)
    @JsonProperty
    private String alreadyAppliedInSixMonths;

    @Column(name="Blacklisted",nullable=true)
    @JsonProperty
    private String blacklisted;

    @Column(name="Anyoffer",nullable=true)
    @JsonProperty
    private String anyOffer;


    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Job(String companyName, String location, String jobProfile, int experienceRequired, String skillRequired, int minNoticePeriod, String alreadyAppliedInSixMonths, String blacklisted, String anyOffer) {
        this.companyName = companyName;
        this.location = location;
        this.jobProfile = jobProfile;
        this.experienceRequired = experienceRequired;
        this.skillRequired = skillRequired;
        this.minNoticePeriod = minNoticePeriod;
        this.alreadyAppliedInSixMonths = alreadyAppliedInSixMonths;
        this.blacklisted = blacklisted;
        this.anyOffer = anyOffer;
    }

    public Job(){}

    @Override
    public String toString() {
        return "Job{" +
                "companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", jobProfile='" + jobProfile + '\'' +
                ", experienceRequired=" + experienceRequired +
                ", skillRequired='" + skillRequired + '\'' +
                ", minNoticePeriod=" + minNoticePeriod +
                ", alreadyAppliedInSixMonths='" + alreadyAppliedInSixMonths + '\'' +
                ", blacklisted='" + blacklisted + '\'' +
                ", anyOffer='" + anyOffer + '\'' +
                '}';
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(String skillRequired) {
        this.skillRequired = skillRequired;
    }

    public int getMinNoticePeriod() {
        return minNoticePeriod;
    }

    public void setMinNoticePeriod(int minNoticePeriod) {
        this.minNoticePeriod = minNoticePeriod;
    }

    public String getAlreadyAppliedInSixMonths() {
        return alreadyAppliedInSixMonths;
    }

    public void setAlreadyAppliedInSixMonths(String alreadyAppliedInSixMonths) {
        this.alreadyAppliedInSixMonths = alreadyAppliedInSixMonths;
    }

    public String getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(String blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getAnyOffer() {
        return anyOffer;
    }

    public void setAnyOffer(String anyOffer) {
        this.anyOffer = anyOffer;
    }





}
