package com.appliances;


import com.appliances.entities.AirConditioner;
import com.appliances.entities.Fan;
import com.appliances.entities.Light;
import com.appliances.repositories.ApplianceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(ApplianceRepo applianceRepo) {
        return args -> {
            // Creating a Light appliance
            Light light = new Light();
            light.setId(1L);  // Setting a manual ID
            light.powerOff();  // Initially turned off
            applianceRepo.save(light);

            // Creating a Fan appliance
            Fan fan = new Fan();
            fan.setId(2L);  // Setting a manual ID
            fan.powerOff();  // Initially turned off
            applianceRepo.save(fan);

            // Creating an Air Conditioner appliance
            AirConditioner ac = new AirConditioner();
            ac.setId(3L);  // Setting a manual ID
            ac.powerOff();  // Initially turned off
            ac.setTemperature(22);  // Set initial temperature
            applianceRepo.save(ac);

            System.out.println("Initial data loaded: One of each appliance type created.");
        };
    }
}
