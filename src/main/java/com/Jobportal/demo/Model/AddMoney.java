package com.Jobportal.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "addmoney")
public class AddMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="money_id")
    private int moneyId;

    @Column(name="username")
    private String username;

    public String getTransactionId() {
        return transactionId;
    }

    public AddMoney(String username, String transactionId, long money) {
        this.username = username;
        this.transactionId = transactionId;
        this.money = money;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name="trans_id")
    private String transactionId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AddMoney(){}

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Column(name="money")
    private long money;



}
