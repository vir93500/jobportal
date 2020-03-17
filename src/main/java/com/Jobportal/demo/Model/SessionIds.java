package com.Jobportal.demo.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="SessionIds")
public class SessionIds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SessionIds(String token,String username) {
        this.username = username;
        this.token = token;
    }
    public SessionIds(){}

    @Column(name="username",nullable=true)
    @JsonProperty
    private String username;

    @Column(name="token",nullable=true)
    @JsonProperty
    private String token;

}
