package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long parentId;
    private String sender;
    private String receiver;
    private int totalAmount;
    private int paidAmount;

    public Child() {

    }

    public Child(long parentId, String sender, String receiver, int totalAmount, int paidAmount) {
        super();
        this.parentId = parentId;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
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

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
}
