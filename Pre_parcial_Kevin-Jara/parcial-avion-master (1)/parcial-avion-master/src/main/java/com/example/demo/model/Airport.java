package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
@Table (name = "airports")
public class Airport {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "city")
    private String city;

    @Column (name = "country")
    private String country;

    @Column (name = "iata_code")
    private String iataCode;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> departingFlights = new ArrayList<>();

    
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> destinationFlight = new ArrayList<>();


    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> destinationTickets = new ArrayList<>();

     @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> originTicket = new ArrayList<>();
}

