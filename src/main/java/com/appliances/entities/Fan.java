package com.appliances.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fan implements IAppliance{
    @Id
    private Long id;
    // 0 = OFF, 1 = LOW, 2 = HIGH
    private int speed;

    @Override
    public void powerOn() {
        this.speed = 1;
    }

    @Override
    public void powerOff() {
        this.speed = 0;
    }

    public void setSpeed(int speed){
        if(speed < 0 || speed > 2)
            throw new IllegalArgumentException("Speed must be between 0 and 2.");

        this.speed = speed;
    }
    @Override
    public String getStatus() {
        return speed == 0 ? "OFF" : "ON - SPEED: " + speed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
