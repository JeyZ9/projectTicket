package com.demo.flight.controller;

import com.demo.flight.entity.Flight;
import com.demo.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {
    private final FlightService flightService;
    @Autowired
    public  FlightController(FlightService flightService ) {
        this.flightService = flightService;
    }
    @GetMapping("/get")
    public List<Flight> getFlights(){
        return flightService.getFlights();
    }

    @PostMapping("/create")
    public void createFlight(
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("price") Double price
    ){
        try{
            byte[] imageBytes = imageFile.getBytes();
            Flight flight = new Flight(imageBytes, name, description, category, price);
            flightService.addFlight(flight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
