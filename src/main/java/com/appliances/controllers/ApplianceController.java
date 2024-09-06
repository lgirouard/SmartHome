package com.appliances.controllers;

import com.appliances.services.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
