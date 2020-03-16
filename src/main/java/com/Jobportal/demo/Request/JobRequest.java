package com.Jobportal.demo.Request;

public class JobRequest {



    private String companyName;

    private String location;

    private String jobProfile;

    private int experienceRequired;

    private String skillRequired;

    private int minNoticePeriod;

    private String alreadyAppliedInSixMonths;

    public String getCompanyName() {
        return companyName;
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

    public JobRequest(String companyName, String location, String jobProfile, String skillRequired) {
        this.companyName = companyName;
        this.location = location;
        this.jobProfile = jobProfile;
        this.skillRequired = skillRequired;
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

    private String blacklisted;

    private String anyOffer;

}
