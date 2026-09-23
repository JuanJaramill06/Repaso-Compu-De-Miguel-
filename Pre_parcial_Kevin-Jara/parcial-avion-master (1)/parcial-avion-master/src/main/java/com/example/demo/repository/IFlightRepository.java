package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginAirport_Name_AndDestinationAirport_Name(String originName, String destinationName);

    List<Flight> findByOriginAirport_Name(String origin);

    List<Flight> findByOriginAirport_City_OrDestinationAirport_City(String originCity, String destinationCity);

    List<Flight> findByDestinationAirport_NameAndArrivalDateBetween(String destinationName, Timestamp startDate, Timestamp endDate);

    List<Flight> findTop5ByArrivalDateBetweenOrderByEstimatedPassengersDesc(Timestamp startDate, Timestamp endDate);
}
