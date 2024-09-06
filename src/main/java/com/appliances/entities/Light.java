package com.appliances.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Light")
public class Light extends ApplianceEntity {

    @Override
    public void powerOn() {
        setOn(true);
    }

    @Override
    public void powerOff() {
        setOn(false);
    }

    @Override
    public String getStatus() {
        return isOn() ? "ON" : "OFF";
    }
}
