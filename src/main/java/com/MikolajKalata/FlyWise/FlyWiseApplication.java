package com.MikolajKalata.FlyWise;

import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.service.FlightService;
import com.MikolajKalata.FlyWise.tools.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class FlyWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyWiseApplication.class, args);

	}

	@Bean
	CommandLineRunner getDataFromJSON(FlightService flightService){
		return args -> {

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new SimpleModule()
					.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer()));
//			objectMapper.registerModule(new ParameterNamesModule());
//			objectMapper.registerModule(new Jdk8Module());
//			objectMapper.registerModule(new JavaTimeModule()); // new module, NOT JSR310Module
//			objectMapper.registerModule(new JodaModule());
//			objectMapper.readerFor(ZonedDateTime.class).with(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
//			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//			objectMapper.setDateFormat(new StdDateFormat());

			TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/flight.json");

			TypeReference<List<Cargo>> typeReference2 = new TypeReference<List<Cargo>>() {};
			InputStream inputStream2 = TypeReference.class.getResourceAsStream("/cargo.json");

			try {

					List<Flight> flightList = objectMapper.readValue(inputStream, typeReference);
					List<Cargo> cargoList = objectMapper.readValue(inputStream2, typeReference2);

				for (int i = 0; i < flightList.size(); i++) {
					for (int j = 0; j < cargoList.get(i).getBaggage().size(); j++) {
						cargoList.get(i).getBaggage().get(j).setCargo(cargoList.get(i));

					}
					for (int j = 0; j < cargoList.get(i).getCargoes().size(); j++) {
						cargoList.get(i).getCargoes().get(j).setCargo(cargoList.get(i));
					}

					cargoList.get(i).setFlight(flightList.get(i));
					flightList.get(i).setCargo(cargoList.get(i));
				}
				flightService.saveFlights(flightList);
			}
			catch (IOException e){
				System.out.println("Cannot save :" + e);
			}
		};
	}
}
