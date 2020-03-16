package com.Jobportal.demo.Response;

public class AllEligibleJobResponse {
    private String companyName;
    private String location;

    public AllEligibleJobResponse() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public AllEligibleJobResponse(String companyName, String location, String jobProfile, String skillRequired, int jobId) {
        this.companyName = companyName;
        this.location = location;
        this.jobProfile = jobProfile;
        this.skillRequired = skillRequired;
        this.jobId = jobId;
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

    public String getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(String skillRequired) {
        this.skillRequired = skillRequired;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    private String jobProfile;
    private String skillRequired;
    private int jobId;
}
