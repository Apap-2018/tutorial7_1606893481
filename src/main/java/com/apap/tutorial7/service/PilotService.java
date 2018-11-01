package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

import java.util.Optional;

/**
 * PilotService
 */
public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);

    PilotModel addPilot(PilotModel pilot);

    void deletePilotByLicenseNumber(String licenseNumber);

    Optional<PilotModel> getPilotDetailById(long id);

    void updatePilot(PilotModel pilot);

    void deletePilot(PilotModel pilot);
}