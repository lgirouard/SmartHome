package com.appliances.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AirConditioner")
public class AirConditioner extends ApplianceEntity {

    private int temperature;

    @Override
    public void powerOn() {
        setOn(true); // Use method from ApplianceEntity
    }

    @Override
    public void powerOff() {
        setOn(false); // Use method from ApplianceEntity
    }

    @Override
    public String getStatus() {
        return isOn() ? "ON - TEMP: " + temperature : "OFF";
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
