package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.repository.IAirlineRepository;
import com.example.demo.repository.IAirplaneRepository;
import com.example.demo.repository.IAirportRepository;
import com.example.demo.repository.IFlightRepository;
import com.example.demo.repository.ITicketFlightRepository;
import com.example.demo.repository.ITicketRepository;

@RestController 
public class Controller {
    
    private final IAirlineRepository airlineRepo;
    private final IAirplaneRepository airplaneRepo;
    private final IAirportRepository airportRepo;
    private final IFlightRepository flightRepository;
    private final ITicketRepository ticketRepo;
    private final ITicketFlightRepository ticketflightRepo;

    @Autowired 
    public Controller(IAirlineRepository airlineRepo, IAirplaneRepository airplaneRepo, IAirportRepository airportRepo, IFlightRepository flightRepository, ITicketRepository ticketRepo, ITicketFlightRepository ticketflightRepo) {
        this.airlineRepo = airlineRepo;
        this.airplaneRepo = airplaneRepo;
        this.airportRepo = airportRepo;
        this.flightRepository = flightRepository;
        this.ticketRepo = ticketRepo;
        this.ticketflightRepo = ticketflightRepo;
    }

    @GetMapping ("/")
    public String home() {
        return "Hola el proyecto funciona";
    }

    @GetMapping("/ejercicio1")
    public List<Flight> getTrayectos(){
        return flightRepository.findByOriginAirport_Name_AndDestinationAirport_Name("El Dorado", "JFK");
    }

    @GetMapping("/ejercicio2")
    public List<Flight> getOrigen(){
        return flightRepository.findByOriginAirport_Name("El Dorado");
    }

    
    @GetMapping("/ejercicio3")
    public List<Flight> getCiudad(){
        return flightRepository.findByOriginAirport_City_OrDestinationAirport_City("Bogota","");
    }

    @GetMapping("/ejercicio4")
    public List<Flight> getRango(){
            Timestamp fechaInicio = Timestamp.valueOf("2026-03-01 00:00:00"); 
            Timestamp fechaFin = Timestamp.valueOf("2026-03-31 23:59:59");
        return flightRepository.findByDestinationAirport_NameAndArrivalDateBetween("Bogota",fechaInicio, fechaFin);
    }

    @GetMapping ("/ejercicio5")
    public List<Flight>getTop5(){
        Timestamp fechaInicio = Timestamp.valueOf("2026-03-01 00:00:00");
        Timestamp fechaFin = Timestamp.valueOf("2026-03-31 23:59:59");

        // 1. Ejecutas tu método del repositorio
        return flightRepository.findTop5ByArrivalDateBetweenOrderByEstimatedPassengersDesc(fechaInicio, fechaFin);
    }
    
}
