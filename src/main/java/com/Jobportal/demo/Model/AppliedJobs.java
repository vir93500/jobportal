package com.Jobportal.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "appliedjob")
public class AppliedJobs {

    @Column(name="Username")
    private String username;

    @Override
    public String toString() {
        return "AppliedJobs{" +
                "username='" + username + '\'' +
                ", jobId=" + jobId +
                ", companyName='" + companyName + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public AppliedJobs(String username, int jobId, String companyName, LocalDateTime timeStamp) {
        this.username = username;
        this.jobId = jobId;
        this.companyName = companyName;
        this.timeStamp = timeStamp;
    }

    public AppliedJobs(){}

    @Id
    @Column(name="Jobid")
    private int jobId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompnatName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Column(name="Companyname")
    private String companyName;

    @Column(name="Timestamp")
    private LocalDateTime timeStamp;
}

