package com.apap.tutorial7.repository;

import com.apap.tutorial7.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * PilotDb
 */
@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
    PilotModel findByLicenseNumber(String licenseNumber);

    void deleteByLicenseNumber(String licenseNumber);

    @Override
    PilotModel save(PilotModel pilot);
}