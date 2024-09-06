package com.appliances.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AirConditioner extends ApplianceEntity{


    @Id
    private Long id;
    private boolean isOn;
    private int temperature;

    @Override
    public void powerOn() {
        this.isOn = true;
    }

    @Override
    public void powerOff() {
    this.isOn = false;
    }

    @Override
    public String getStatus() {
        return isOn ? "ON - TEMP: " +temperature : "OFF";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
