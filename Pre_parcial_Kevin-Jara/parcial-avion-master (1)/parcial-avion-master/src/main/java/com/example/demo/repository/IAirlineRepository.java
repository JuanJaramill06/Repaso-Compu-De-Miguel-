package com.example.demo.repository;

import com.example.demo.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirlineRepository extends JpaRepository<Airline, Long> {
}
