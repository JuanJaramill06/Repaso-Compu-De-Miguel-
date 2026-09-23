package com.example.demo.repository;

import com.example.demo.model.Flight;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAirport_NameAndDestinationAirport_Name(String originAirportName, String destinationAirportName);

    List<Flight> findByOriginAirport_Name(String originAirportName);

    List<Flight> findByOriginAirport_CityOrDestinationAirport_City(String originCity, String destinationCity);

    List<Flight> findByDestinationAirport_NameAndArrivalDateBetween(String destinationAirportName, Timestamp startDate, Timestamp endDate);

    List<Flight>  findByArrivalDateBetweenOrderByEstimatedPassengersDesc(Timestamp startDate, Timestamp endDate);
}
