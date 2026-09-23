package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.repository.IAirlineRepository;
import com.example.demo.repository.IAirplaneRepository;
import com.example.demo.repository.IAirportRepository;
import com.example.demo.repository.IFlightRepository;
import com.example.demo.repository.ITicketFlightRepository;
import com.example.demo.repository.ITicketRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
//http://localhost:8081/compunet2-2026/ejercicio1?originAirportName=El Dorado&destinationAirportName=JFK
//http://localhost:8081/compunet2-2026/ejercicio2?origenAirportName=El Dorado
//http://localhost:8081/compunet2-2026/ejercicio3?originCity=Bogota&destinationCity=Bogota
//http://localhost:8081/compunet2-2026/ejercicio4?destinationAirportName=El Dorado&startDate=2026-03-01 00:00:00&endDate=2026-03-11 23:59:59
//http://localhost:8081/compunet2-2026/ejercicio5?startDate=2026-03-01 00:00:00&endDate=2026-03-21 23:59:59
    private final IFlightRepository flightRepository;
    private final IAirlineRepository airlineRepo;
    private final IAirplaneRepository airplaneRepo;
    private final IAirportRepository airportRepo;
    private final ITicketRepository ticketRepo;
    private final ITicketFlightRepository ticketflightRepo;

    @GetMapping("/")
    public String home() {
        return "Hola el proyecto funciona";
    }

    @GetMapping("/ejercicio1")
    public List<Flight> getTrayectos(@RequestParam String originAirportName, @RequestParam String destinationAirportName) {
        return flightRepository.findByOriginAirport_NameAndDestinationAirport_Name(originAirportName, destinationAirportName);
    }

    @GetMapping("/ejercicio2")
    public List<Flight> getOrigen(@RequestParam String origenAirportName) {
        return flightRepository.findByOriginAirport_Name(origenAirportName);
    }

    @GetMapping("/ejercicio3")
    public List<Flight> getCiudad(@RequestParam String originCity, @RequestParam String destinationCity) {
        return flightRepository.findByOriginAirport_CityOrDestinationAirport_City(originCity, destinationCity);
    }

    @GetMapping("/ejercicio4")
    public List<Flight> getRango(
         @RequestParam String destinationAirportName,
         @RequestParam String startDate,
         @RequestParam String endDate) {
        Timestamp start = Timestamp.valueOf(startDate);
        Timestamp end = Timestamp.valueOf(endDate);
        return flightRepository.findByDestinationAirport_NameAndArrivalDateBetween(destinationAirportName, start, end);
    }
    @GetMapping("/ejercicio5")
    public List<Flight> getTop5(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        Timestamp start = Timestamp.valueOf(startDate);
        Timestamp end = Timestamp.valueOf(endDate);
        return flightRepository.findByArrivalDateBetweenOrderByEstimatedPassengersDesc(start, end);
    }
}
