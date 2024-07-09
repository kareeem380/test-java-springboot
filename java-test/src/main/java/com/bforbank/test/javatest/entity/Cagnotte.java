package com.bforbank.test.javatest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cagnotte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private int passageCount;
    private double amount;

    // Constructeurs, getters et setters
    public Cagnotte() {}

    public Cagnotte(Long clientId, int passageCount, double amount) {
        this.clientId = clientId;
        this.passageCount = passageCount;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getPassageCount() {
        return passageCount;
    }

    public void setPassageCount(int passageCount) {
        this.passageCount = passageCount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
