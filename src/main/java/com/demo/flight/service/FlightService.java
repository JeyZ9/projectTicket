package com.demo.flight.service;

import com.demo.flight.entity.Flight;
import com.demo.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }
    public void addFlight(Flight flight){
        Optional<Flight> flightOptional = flightRepository.findFlightById(flight.getId());
            if(flightOptional.isPresent()){
                throw new IllegalArgumentException("Flight Taken");
            }
            flightRepository.save(flight);
    }
}
