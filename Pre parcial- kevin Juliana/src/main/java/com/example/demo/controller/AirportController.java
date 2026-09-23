package com.example.demo.controller;

import com.example.demo.model.Airport;
import com.example.demo.repository.IAirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final IAirportRepository airportRepository;

    @GetMapping
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }
}
