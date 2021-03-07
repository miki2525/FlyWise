package com.MikolajKalata.FlyWise.service;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.repository.CargoRepository;
import com.MikolajKalata.FlyWise.repository.FlightRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    private CargoRepository cargoRepository;

    public FlightService(FlightRepository flightRepository, CargoRepository cargoRepository){
        this.flightRepository = flightRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public void clearAll(){
        flightRepository.deleteAll();
    }

    public Flight saveFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public Flight getWeightDetails(Integer flightNum, Date date){
        return flightRepository.getFlightByFlightNumberAndDepartureDate(flightNum, date);
    }

    public Long getNumOfFlightsDep(String depCode, Date date){
        return flightRepository.getNumberOfFlightsDepByDepartureAirportIATACodeAndDepartureDate(depCode, date);
    }

    public Long getNumOfPiecesDep(String depCode, Date date){
        Long notNull = flightRepository.getNumberOfPiecesDepByDepartureAirportIATACodeAndDepartureDate(depCode, date);
        return notNull != null ? notNull : 0L;
    }

    public Long getNumOfFlightsArr(String depCode, Date date){
        return flightRepository.getNumberOfFlightsArrByArrivalAirportIATACodeAndDepartureDate(depCode, date);
    }

    public Long getNumOfPiecesArr(String depCode, Date date){
        Long notNull = flightRepository.getNumberOfPiecesArrByArrivalAirportIATACodeAndDepartureDate(depCode, date);
        return notNull != null ? notNull : 0L;
    }












}
