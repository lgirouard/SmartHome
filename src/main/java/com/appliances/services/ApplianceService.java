package com.appliances.services;

import com.appliances.entities.AirConditioner;
import com.appliances.entities.ApplianceEntity;
import com.appliances.entities.Fan;
import com.appliances.entities.IAppliance;
import com.appliances.repositories.ApplianceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplianceService {

    @Autowired
    private ApplianceRepo applianceRepo;

    public String turnPowerOn(Long id){
        Optional<ApplianceEntity> appliance = applianceRepo.findById(id);

        if(appliance.isPresent()){
            appliance.get().powerOn();
            applianceRepo.save(appliance.get());
            return appliance.get().getStatus();
        }
        return "Appliance not found!";
    }
    public String turnPowerOff(Long id){
        Optional<ApplianceEntity> appliance = applianceRepo.findById(id);

        if(appliance.isPresent()){
            appliance.get().powerOff();
            applianceRepo.save(appliance.get());
            return appliance.get().getStatus();
        }
        return "Appliance not found!";
    }

    public List<ApplianceEntity> findAll() {
        List<ApplianceEntity> applianceList = applianceRepo.findAll();

        if(!applianceList.isEmpty()){
            return applianceList;
        }

        return applianceList;
    }


    public String setFanSpeed(Long id, int speed) {
        Optional<ApplianceEntity> appliance = applianceRepo.findById(id);

        if (appliance.isPresent() && appliance.get() instanceof Fan) {
            Fan fan = (Fan) appliance.get();
            try {
                fan.setSpeed(speed);
                if (speed == 0) {
                    fan.powerOff();  // Turn off if speed is 0
                }
                applianceRepo.save(fan);
                return fan.getStatus();
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        return "Fan not found!";
    }


    public String setAirConditionerTemperature(Long id, int temperature) {
        Optional<ApplianceEntity> appliance = applianceRepo.findById(id);

        if (appliance.isPresent() && appliance.get() instanceof AirConditioner) {
            AirConditioner ac = (AirConditioner) appliance.get();
            ac.setTemperature(temperature);
            applianceRepo.save(ac);
            return ac.getStatus();
        }
        return "Air Conditioner not found!";
    }
}
