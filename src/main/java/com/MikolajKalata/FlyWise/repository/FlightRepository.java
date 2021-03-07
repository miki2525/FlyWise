package com.MikolajKalata.FlyWise.repository;

import com.MikolajKalata.FlyWise.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE " +
            "f.flightNumber= :flightNum AND CAST(f.departureDate AS date) = :date")
    Flight getFlightByFlightNumberAndDepartureDate(Integer flightNum, Date date);


    @Query("SELECT COUNT(f) FROM Flight f WHERE " +
            "f.departureAirportIATACode= :depCode AND CAST(f.departureDate AS date) = :date")
    Long getNumberOfFlightsDepByDepartureAirportIATACodeAndDepartureDate(String depCode, Date date);


    @Query ("SELECT SUM(b.pieces) FROM Baggage b " +
            "JOIN Cargo c ON b.cargo.flightId = c.flightId JOIN " +
            "Flight f ON c.flightId =f.flightId WHERE " +
            "f.departureAirportIATACode= :depCode AND CAST(f.departureDate AS date) = :date")
    Long getNumberOfPiecesDepByDepartureAirportIATACodeAndDepartureDate(String depCode, Date date);


    @Query("SELECT COUNT(f) FROM Flight f WHERE " +
            "f.arrivalAirportIATACode= :arrCode AND CAST(f.departureDate AS date) = :date")
    Long getNumberOfFlightsArrByArrivalAirportIATACodeAndDepartureDate(String arrCode, Date date);


    @Query ("SELECT SUM(b.pieces) FROM Baggage b " +
            "JOIN Cargo c ON b.cargo.flightId = c.flightId JOIN " +
            "Flight f ON c.flightId =f.flightId WHERE " +
            "f.arrivalAirportIATACode= :arrCode AND CAST(f.departureDate AS date) = :date")
    Long getNumberOfPiecesArrByArrivalAirportIATACodeAndDepartureDate(String arrCode, Date date);


    /*/////////////////////////////////////////////////////////////////////////////////////////
    If ArrivalDate would be known( =private ZonedDateTime arrivalDate field in model)

    @Query("SELECT COUNT(f) FROM Flight f WHERE " +
            "f.arrivalAirportIATACode= :arrCode AND CAST(f.arrivalDate AS date) = :date")
    Long getNumberOfFlightsArrByArrivalAirportIATACodeAndArrivalDate(String arrCode, Date date);


    @Query ("SELECT SUM(b.pieces) FROM Baggage b " +
            "JOIN Cargo c ON b.cargo.flightId = c.flightId JOIN " +
            "Flight f ON c.flightId =f.flightId WHERE " +
            "f.arrivalAirportIATACode= :arrCode AND CAST(f.arrivalDate AS date) = :date")
    Long getNumberOfPiecesArrByArrivalAirportIATACodeAndArrivalDate(String arrCode, Date date);
     *////////////////////////////////////////////////////////////////////////////////////////
}
