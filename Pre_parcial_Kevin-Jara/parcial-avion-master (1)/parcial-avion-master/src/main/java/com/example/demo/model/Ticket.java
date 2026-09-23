package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "passenger_full_name")
    private String passengerFullName;

    @Column (name = "booking_code")
    private String bookingCode;

    @Column (name = "purchase_date")
    private Timestamp purchaseDate;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "origin_airport_id")
    private Airport originAirport;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "destination_airport_id")
    private Airport destinationAirport;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore 
    private List<TicketFlight> ticketFlights = new ArrayList<>();
}
