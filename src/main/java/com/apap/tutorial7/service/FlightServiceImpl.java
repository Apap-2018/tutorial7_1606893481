package com.apap.tutorial7.service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightById(Long flightId) {
        return flightDb.findById(flightId);
    }

    @Override
    public FlightModel updateFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public List<FlightModel> findAll() {
        return flightDb.findAll();
    }

    @Override
    public void delete(Long flightId) {
        flightDb.deleteById(flightId);
    }
}