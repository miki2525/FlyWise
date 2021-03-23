package com.MikolajKalata.FlyWise.model;

import com.MikolajKalata.FlyWise.tools.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq", initialValue = 0)

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long flightId;

    private Integer flightNumber;

    private String departureAirportIATACode;

    private String arrivalAirportIATACode;

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime departureDate;

//    private ZonedDateTime arrivalDate;

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cargo cargo;


    public Flight() {
    }

    public Flight(Integer flightNumber, String departureAirportIATACode, String arrivalAirportIATACode, ZonedDateTime departureDate) {
        this.flightNumber = flightNumber;
        this.departureAirportIATACode = departureAirportIATACode;
        this.arrivalAirportIATACode = arrivalAirportIATACode;
        this.departureDate = departureDate;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public ZonedDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(ZonedDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureAirportIATACode, flight.departureAirportIATACode) && Objects.equals(arrivalAirportIATACode, flight.arrivalAirportIATACode) && Objects.equals(departureDate, flight.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, departureAirportIATACode, arrivalAirportIATACode, departureDate);
    }
}
