package com.apap.tutorial7.repository;

import com.apap.tutorial7.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
    void deleteByFlightNumber(String flightNumber);

    Optional<FlightModel> findByFlightNumber(String flightNumber);

    @Override
    Optional<FlightModel> findById(Long aLong);

    @Override
    List<FlightModel> findAll();

    @Override
    void deleteById(Long aLong);
}