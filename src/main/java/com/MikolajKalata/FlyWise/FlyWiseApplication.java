package com.MikolajKalata.FlyWise;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.repository.CargoRepository;
import com.MikolajKalata.FlyWise.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;

@SpringBootApplication
public class FlyWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyWiseApplication.class, args);

	}

}
