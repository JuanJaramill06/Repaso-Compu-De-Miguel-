package com.example.demo.controller;

import com.example.demo.model.Airline;
import com.example.demo.repository.IAirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final IAirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }

}
