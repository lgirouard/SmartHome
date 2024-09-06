package com.appliances.repositories;

import com.appliances.entities.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepo extends JpaRepository<ApplianceEntity, Long> {
}
