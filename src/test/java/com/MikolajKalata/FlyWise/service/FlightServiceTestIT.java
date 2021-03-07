package com.MikolajKalata.FlyWise.service;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import com.MikolajKalata.FlyWise.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class FlightServiceTestIT {

    @Autowired
    private FlightService flightService;

    @Autowired
    private CargoService cargoService;

    private Flight flightTest;

    private  Date date;

    @BeforeEach
    void initData(){

        flightService.clearAll();

        flightTest = new Flight(2005, "KRK", "SEA", ZonedDateTime.now());
        Cargo cargoTest = new Cargo();
        cargoTest.getCargoes().add(new Cargoes(100, "kg", 100, cargoTest));
        cargoTest.getCargoes().add(new Cargoes(200, "lb", 25, cargoTest));
        cargoTest.getBaggage().add(new Baggage(200, "lb", 350, cargoTest));
        cargoTest.getBaggage().add(new Baggage(350, "lb", 999, cargoTest));
        cargoTest.getBaggage().add(new Baggage(600, "kg", 675, cargoTest));
        cargoTest.setFlight(flightTest);
        flightTest.setCargo(cargoTest);
        cargoService.saveCargo(cargoTest);
        flightService.saveFlight(flightTest);

        date = Date.valueOf(flightTest.getDepartureDate().toLocalDate());
    }

    @Test
    void findAll() {
        //
        flightService.saveFlight(new Flight(3000, "BYD",
                "ROM", ZonedDateTime.now()));
        //
        List<Flight> testList = flightService.findAll();
        //
        assertThat(testList).hasSize(2);
    }

    @Test
    void clearAll() {
        //
        //
        flightService.clearAll();;
        List<Flight> testList = flightService.findAll();
        //
        assertThat(testList).isEmpty();
    }

    @Test
    void saveFlight() {
        //
        //
        Flight flTest = flightService.saveFlight(new Flight(3000, "BYD",
                "ROM", ZonedDateTime.now()));
        //
        assertThat(flTest.getFlightId()).isPositive();
    }

    @Test
    void getWeightDetails() {
        //
        //
        Flight flTest = flightService.getWeightDetails(flightTest.getFlightNumber(), date);
        //
        assertThat(flTest).isNotNull();
        assertThat(flTest).isEqualTo(flightTest);
    }

    @Test
    void shouldNotGetWeightDetails() {
        //
        //
        Flight flTest = flightService.getWeightDetails(5, date);
        //
        assertThat(flTest).isNull();
    }

    @Test
    void getNumOfFlightsDep() {
        //
        //
        Long num = flightService.getNumOfFlightsDep("KRK", date);
        //
        assertThat(num).isEqualTo(1L);
    }

    @Test
    void getNumOfPiecesDep() {
        //
        //
        Long num = flightService.getNumOfPiecesDep("KRK", date);
        //
        assertThat(num).isNotZero();
    }

    @Test
    void getNumOfFlightsArr() {
        //
        //
        Long num = flightService.getNumOfFlightsDep("SEA", date);
        //
        assertThat(num).isZero();
    }

    @Test
    void getNumOfPiecesArr() {
        //
        //
        Long num = flightService.getNumOfPiecesArr("SEA", date);
        //
        assertThat(num).isEqualTo(2024L);

    }
}