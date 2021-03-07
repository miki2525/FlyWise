package com.MikolajKalata.FlyWise.controller;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.service.CargoService;
import com.MikolajKalata.FlyWise.service.FlightService;
import com.MikolajKalata.FlyWise.tools.WeightCalculator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FlightRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    FlightService flightService;

    @Autowired
    CargoService cargoService;

    @Autowired
    ObjectMapper objectMapper;

    Flight flightTest;

    @BeforeEach
    void setUp(){

        flightService.clearAll();

        flightTest = new Flight(1000, "SEA", "GDN", ZonedDateTime.now());

        Cargo cargo = new Cargo();
        cargo.getCargoes().add(new Cargoes(100, "kg", 100, cargo));
        cargo.getCargoes().add(new Cargoes(200, "lb", 25, cargo));
        cargo.getBaggage().add(new Baggage(200, "lb", 350, cargo));
        cargo.getBaggage().add(new Baggage(350, "lb", 999, cargo));
        cargo.getBaggage().add(new Baggage(600, "kg", 675, cargo));

        cargo.setFlight(flightTest);
        flightTest.setCargo(cargo);

        cargoService.saveCargo(cargo);
        flightService.saveFlight(flightTest);



    }


    @Test
    void getWeightDetails() throws Exception {
        Integer sum1 = WeightCalculator.getBaggageTotalWeight(flightTest.getCargo().getBaggage());
        Integer sum2 = WeightCalculator.getCargoesTotalWeight(flightTest.getCargo().getCargoes());
        Integer totalSum = sum1 + sum2;

        mockMvc.perform(post("/getWeightDetails")
                .param("dateStr",LocalDate.now().toString())
                .param("flightNum", "1000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "{\"totalBaggage\":" + sum1 +
                        ",\"totalCargo\":" + sum2 +
                        ",\"totalWeight\":" + totalSum +
                        "}"));

    }

    @Test
    void getAirportDetails() throws Exception {
        Flight flightTest2 = new Flight(2005, "KRK", "SEA", ZonedDateTime.now());
        Cargo cargo2 = new Cargo();
        cargo2.getCargoes().add(new Cargoes(100, "kg", 100, cargo2));
        cargo2.getCargoes().add(new Cargoes(200, "lb", 25, cargo2));
        cargo2.getBaggage().add(new Baggage(200, "lb", 350, cargo2));
        cargo2.getBaggage().add(new Baggage(350, "lb", 999, cargo2));
        cargo2.getBaggage().add(new Baggage(600, "kg", 675, cargo2));
        cargo2.setFlight(flightTest2);
        flightTest2.setCargo(cargo2);
        cargoService.saveCargo(cargo2);
        flightService.saveFlight(flightTest2);

        Long numOfFlightsDep = flightService.getNumOfFlightsDep("SEA", Date.valueOf(LocalDate.now()));
        Long numOfFlightsArr = flightService.getNumOfFlightsArr("SEA", Date.valueOf(LocalDate.now()));
        Long numOfPiecesDep = flightService.getNumOfPiecesDep("SEA", Date.valueOf(LocalDate.now()));
        Long numOfPiecesArr = flightService.getNumOfPiecesArr("SEA", Date.valueOf(LocalDate.now()));

        mockMvc.perform(post("/getAirportDetails")
                .param("dateStr",LocalDate.now().toString())
                .param("airCode", "SEA"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "{\"numOfFlightDep\":" + numOfFlightsDep +
                        ",\"numOfFlightArr\":" + numOfFlightsArr +
                        ",\"totalNumOfBaggDep\":" + numOfPiecesDep +
                        ",\"totalNumOfBaggArr\":" + numOfPiecesArr +
                        "}"));
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}