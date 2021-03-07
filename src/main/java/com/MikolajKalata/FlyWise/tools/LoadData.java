package com.MikolajKalata.FlyWise.tools;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.repository.CargoRepository;
import com.MikolajKalata.FlyWise.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class LoadData implements ApplicationRunner {
    private FlightRepository flightRepository;

    private CargoRepository cargoRepository;

    @Autowired
    public LoadData(FlightRepository flightRepository, CargoRepository cargoRepository){
        this.flightRepository = flightRepository;
        this.cargoRepository = cargoRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        int num = 1000;
        int w1 = 25;
        int w2 = 155;
        int w3 = 255;
        int w4 = 5;

        for (int i = 0; i < 5; i++) {

            Flight flight = new Flight(num++, "SEA", "GDA", ZonedDateTime.now());
            Cargo cargo = new Cargo();
            cargo.getCargoes().add(new Cargoes(w1++, "kg", w2++, cargo));
            cargo.getCargoes().add(new Cargoes(w3++, "lb", w2++, cargo));
            cargo.getBaggage().add(new Baggage(w2++, "lb", w4++, cargo));
            cargo.getBaggage().add(new Baggage(w3++, "lb", w1++, cargo));
            cargo.getBaggage().add(new Baggage(w4++, "kg", w3++, cargo));

            cargo.setFlight(flight);
            flight.setCargo(cargo);


            cargoRepository.save(cargo);
            flightRepository.save(flight);

        }
    }
}
