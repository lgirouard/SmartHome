package com.appliances.controllers;

import com.appliances.entities.ApplianceEntity;
import com.appliances.services.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/appliances")
public class ApplianceController {
    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @PostMapping("/{id}/off")
    public String turnOffAppliance(@PathVariable Long id){
        return applianceService.turnPowerOff(id);
    }

    @PostMapping("/{id}/on")
    public String turnOnAppliance(@PathVariable Long id){
        return applianceService.turnPowerOn(id);
    }

    @GetMapping("/test")
    public String test(){
        return "API is working!";
    }

    @GetMapping("/status/all")
    public List<String> getAllStatuses() {
        List<ApplianceEntity> appliances = applianceService.findAll();
        return appliances.stream()
                .map(ApplianceEntity::getStatus)
                .collect(Collectors.toList());
    }

    // Set fan speed (0 = OFF, 1 = LOW, 2 = HIGH)
    @PostMapping("/fan/{id}/speed")
    public String setFanSpeed(@PathVariable Long id, @RequestParam int speed) {
        return applianceService.setFanSpeed(id, speed);
    }

    // Set air conditioner temperature (THERMOSTAT)
    @PostMapping("/airconditioner/{id}/temperature")
    public String setAirConditionerTemperature(@PathVariable Long id, @RequestParam int temperature) {
        return applianceService.setAirConditionerTemperature(id, temperature);
    }



}
