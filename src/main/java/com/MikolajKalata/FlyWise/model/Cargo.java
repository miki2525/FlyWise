package com.MikolajKalata.FlyWise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cargo {

    @Id
    private Long flightId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
    private List<Baggage> baggage = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
    private List<Cargoes> cargo = new ArrayList<>();


    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    public Cargo() {

    }

    public Cargo(Long flightId, List<Baggage> baggage, List<Cargoes> cargo) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargo = cargo;
    }


    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    public List<Cargoes> getCargoes() {
        return cargo;
    }

    public void setCargoes(List<Cargoes> cargo) {
        this.cargo = cargo;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo1 = (Cargo) o;
        return Objects.equals(baggage, cargo1.baggage) && Objects.equals(cargo, cargo1.cargo) && Objects.equals(flight, cargo1.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, baggage, cargo);
    }
}
