package com.appliances.repositories;

import com.appliances.entities.ApplianceEntity;
import com.appliances.entities.IAppliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepo extends JpaRepository<ApplianceEntity, Long> {
}
