package com.example.demo.model;

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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airports")
public class Airport {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "name", nullable = false)
    private String name;
    @Column (name = "city", nullable = false)
    private String city;
    @Column (name = "country", nullable = false)
    private String country;
    @Column (name = "iata_code", nullable = false)
    private String iataCode;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Flight> departingFlights = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Flight> arrivingFlights = new ArrayList<>();
        
    @JsonIgnore 
    @ToString.Exclude
    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Ticket> departingTickets = new ArrayList<>();

    @JsonIgnore 
    @ToString.Exclude
    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Ticket> destinationTickets = new ArrayList<>();
}
