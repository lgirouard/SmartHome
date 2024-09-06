package com.appliances.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Fan")
public class Fan extends ApplianceEntity {

    // 0 = OFF, 1 = LOW, 2 = HIGH
    private int speed;

    @Override
    public void powerOn() {
        this.speed = 1; // Default to LOW when powered on
        setOn(true);
    }

    @Override
    public void powerOff() {
        this.speed = 0; // Set speed to OFF when powered off
        setOn(false);
    }

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Speed must be between 0 and 2.");
        }
        if(speed != 0){
            this.powerOn();
        }
        this.speed = speed;
    }

    @Override
    public String getStatus() {
        return speed == 0 ? "OFF" : "ON - SPEED: " + speed;
    }

    public int getSpeed() {
        return speed;
    }
}
