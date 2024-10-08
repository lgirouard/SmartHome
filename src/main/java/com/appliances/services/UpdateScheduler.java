package com.appliances.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateScheduler {

    private final ApplianceService applianceService;

    @Autowired
    public UpdateScheduler(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    // method runs once a year on January 1st at 1:00 AM
    @Scheduled(cron = "0 0 1 1 1 *")
    public void performSystemUpdate() {
        System.out.println("Performing annual system update. Turning off all appliances.");

        applianceService.turnOffAllAppliances();
    }
}
