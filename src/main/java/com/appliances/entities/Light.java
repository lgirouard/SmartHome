package com.appliances.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Light implements IAppliance{
    @Id
    private Long id;
    private boolean isOn;

    @Override
    public void powerOn() { this.isOn = true; }

    @Override
    public void powerOff() { this.isOn = false;}

    @Override
    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
