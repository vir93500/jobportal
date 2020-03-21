package com.Jobportal.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "transactionid")
public class TransactionId {

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public TransactionId(String transId) {
        this.transId = transId;
    }

    public TransactionId(){}

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private int Id;

        @Column(name="trans_id")
        private String transId;

}
