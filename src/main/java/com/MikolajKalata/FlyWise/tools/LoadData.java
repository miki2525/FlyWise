//package com.MikolajKalata.FlyWise.tools;
//
//import com.MikolajKalata.FlyWise.model.Baggage;
//import com.MikolajKalata.FlyWise.model.Cargo;
//import com.MikolajKalata.FlyWise.model.Cargoes;
//import com.MikolajKalata.FlyWise.model.Flight;
//import com.MikolajKalata.FlyWise.repository.CargoRepository;
//import com.MikolajKalata.FlyWise.repository.FlightRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import java.lang.reflect.Array;
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public class LoadData implements ApplicationRunner {
//
//    private FlightRepository flightRepository;
//
//    private CargoRepository cargoRepository;
//
//    @Autowired
//    public LoadData(FlightRepository flightRepository, CargoRepository cargoRepository){
//        this.flightRepository = flightRepository;
//        this.cargoRepository = cargoRepository;
//    }
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        int num = 1000;
//        long w0 = 0l;
//        int w1 = 25;
//        int w2 = 155;
//        int w3 = 255;
//        int w4 = 5;
//
//        for (int i = 0; i < 5; i++) {
//            w0 = 0l;
//            Flight flight = new Flight(num++, "SEA", "GDN", ZonedDateTime.now());
//            Cargo cargo = new Cargo();
//            cargo.getCargoes().add(new Cargoes(w0++, w1++, "kg", w2++, cargo));
//            cargo.getCargoes().add(new Cargoes(w0++, w3++, "lb", w2++, cargo));
//            cargo.getBaggage().add(new Baggage(w0++, w2++, "lb", w4++, cargo));
//            cargo.getBaggage().add(new Baggage(w0++, w3++, "lb", w1++, cargo));
//            cargo.getBaggage().add(new Baggage(w0++, w4++, "kg", w3++, cargo));
//            cargo.setFlight(flight);
//            flight.setCargo(cargo);
//            flightRepository.save(flight);
//        }
//
//        String[] depCodeArr = {"SEA","YYZ","YYT","ANC","LAX"};
//        String[] arrCodeArr = {"MIT","LEW","GDN","KRK","PPX"};
//        String[] unitArr = {"kg", "lb"};
//        List<Cargo> cargoList = new ArrayList<>();
//        List<Flight> flightList = new ArrayList<>();
//        long id;
//        Double randomNumFl;
//        Double randomUnit;
//        Double randomBag;
//        Double randomCar;
//        Double randomDepCode;
//        Double randomArrCode;
//        Double randomDays;
//        Double weight;
//        Double pieces;
//        String unit;
//        String depCode;
//        String arrCode;
//        ZonedDateTime date;
//        for (int i = 0; i < 200; i++) {
//
//            randomNumFl = Math.random() * (9998 - 1000 + 1) + 1000;
//
//            randomBag = Math.random() * (8 - 3 + 1) + 3;
//            randomCar = Math.random() * (8 - 3 + 1) + 3;
//            randomDepCode = Math.random() * (4 - 0 + 1) + 0;
//            randomArrCode = Math.random() * (4 - 0 + 1) + 0;
//            randomDays = Math.random() * (7 - 0 + 1) + 0;
//
//
//            depCode = (String) Array.get(depCodeArr, randomDepCode.intValue());
//            arrCode = (String) Array.get(arrCodeArr, randomArrCode.intValue());
//            date = ZonedDateTime.now().plusDays(randomDays.intValue());
//
//
//            flightList.add(new Flight(randomNumFl.intValue(), depCode, arrCode, date));
//            cargoList.add(new Cargo());
//
//            id = 0l;
//            for(int j = 0; j < randomBag; j++) {
//                weight = Math.random() * (999 - 1 + 1) + 1;
//                pieces =  Math.random() * (999 - 1 + 1) + 1;
//                randomUnit =  Math.random() * (1 - 0 + 1) + 0;
//
//                unit = (String) Array.get(unitArr, randomUnit.intValue());
//                cargoList.get(i).getBaggage().add(new Baggage(id++, weight.intValue(), unit, pieces.intValue(), cargoList.get(i)));
//            }
//
//            id = 0l;
//            for(int k = 0; k < randomCar; k++) {
//                weight = Math.random() * (999 - 1 + 1) + 1;
//                pieces = Math.random() * (999 - 1 + 1) + 1;
//                randomUnit = Math.random() * (1 - 0 + 1) + 0;
//                unit = (String) Array.get(unitArr, randomUnit.intValue());
//
//                cargoList.get(i).getCargoes().add(new Cargoes(id++, weight.intValue(), unit, pieces.intValue(), cargoList.get(i)));
//            }
//
//            cargoList.get(i).setFlight(flightList.get(i));
//            flightList.get(i).setCargo(cargoList.get(i));
//            flightRepository.save(flightList.get(i));
//
//            }
//        }
//    }
//
