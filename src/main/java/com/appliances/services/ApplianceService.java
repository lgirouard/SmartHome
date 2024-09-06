package com.appliances.services;

import com.appliances.entities.ApplianceEntity;
import com.appliances.entities.IAppliance;
import com.appliances.repositories.ApplianceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
