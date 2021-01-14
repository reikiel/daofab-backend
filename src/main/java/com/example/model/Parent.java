package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sender;
    private String receiver;
    private int totalAmount;
    private int totalPaidAmount;

    public Parent() {

    }

    public Parent(String sender, String receiver, int totalAmount) {
        super();
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(int totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }
}
