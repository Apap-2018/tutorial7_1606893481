package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.FlightService;
import com.apap.tutorial7.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private PilotService pilotService;


    @PostMapping(value="/add")
    public FlightModel addFlight(@RequestBody FlightModel flight) {
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber("1234");
        flight.setPilot(pilot);
        pilot.getListFlight().add(flight);

        return flightService.addFlight(flight);
    }

    @PutMapping(value = "/update/{flightId}")
    public String updateFlight(@PathVariable(value = "flightId") long flightId,
                               @RequestParam(value = "destination", defaultValue = "") String destination,
                               @RequestParam(value = "origin", defaultValue = "") String origin,
                               @RequestParam(value = "time", defaultValue = "") String time) {
        FlightModel flight = flightService.getFlightById(flightId).get();
        if (flight.equals(null)){
            return "Couldn't find your flight";
        }
        if(!destination.equals(""))
            flight.setDestination(destination);
        if(!origin.equals(""))
            flight.setOrigin(origin);
        if (!time.equals(""))
            flight.setTime(java.sql.Date.valueOf(time));

        flightService.updateFlight(flight);
        return "flight update success";
    }

    @GetMapping(value="/view/{flightNumber}")
    public FlightModel updateFlight(@PathVariable(value = "flightNumber") String flightNumber) {
        FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();

        return flight;
    }

    @GetMapping(value = "/all")
    public List<FlightModel> viewAll() {
        return flightService.findAll();
    }

    @DeleteMapping(value = "/{flightId}")
    public String deleteFlight(@PathVariable(value = "flightId") long flightId){
        FlightModel flight = flightService.getFlightById(flightId).get();
        if (flight.equals(null)) {
            return "flight doesn't exist";
        }

        flightService.delete(flightId);
        return "flight has been deleted";
    }

}