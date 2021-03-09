package com.MikolajKalata.FlyWise.controller;


import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.service.FlightService;
import com.MikolajKalata.FlyWise.tools.AirportDetails;
import com.MikolajKalata.FlyWise.tools.WeightCalculator;
import com.MikolajKalata.FlyWise.tools.Weights;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class FlightRestController {

    private FlightService flightService;

    public FlightRestController(FlightService flightService){
        this.flightService = flightService;
    }


    @PostMapping("/getWeightDetails")
    public ResponseEntity<Weights> getWeightDetails (@RequestParam("dateStr") String dateStr, @RequestParam("flightNum") Integer flightNum){

        Date date = Date.valueOf(dateStr);

        Flight flight = flightService.getWeightDetails(flightNum, date);
        if (flight == null){
            return ResponseEntity.notFound().build();
        }

        Integer totalBaggageWeight = WeightCalculator.getBaggageTotalWeight(flight.getCargo().getBaggage());
        Integer totalCargoWeight = WeightCalculator.getCargoesTotalWeight(flight.getCargo().getCargoes());
        Integer totalSum = totalBaggageWeight + totalCargoWeight;               //+ more(crew, passengers, aircraft, fuel)

        Weights weights = new Weights(totalBaggageWeight, totalCargoWeight, totalSum);

        return ResponseEntity.ok(weights);
    }

    @PostMapping("/getAirportDetails")
    public ResponseEntity<AirportDetails> getAirportDetails(@RequestParam("dateStr") String dateStr, @RequestParam("airCode") String airCode){

        Date date = Date.valueOf(dateStr);

        Long numOfFlightsDep = flightService.getNumOfFlightsDep(airCode, date);
        Long numOfFlightsArr = flightService.getNumOfFlightsArr(airCode, date);
        Long numOfPiecesDep = flightService.getNumOfPiecesDep(airCode, date);
        Long numOfPiecesArr = flightService.getNumOfPiecesArr(airCode, date);

        if(!AirportDetails.validate(numOfFlightsDep, numOfFlightsArr, numOfPiecesDep, numOfPiecesArr)){
           return ResponseEntity.notFound().build();
        }
        AirportDetails airportDetails = new AirportDetails(numOfFlightsDep, numOfFlightsArr, numOfPiecesDep, numOfPiecesArr);

        return ResponseEntity.ok(airportDetails);
    }

    @GetMapping("/api")
    public ResponseEntity<List<Flight>> findAll(){
        return ResponseEntity.ok(flightService.findAll());
    }


/*    @PostMapping("/api")
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
        return ResponseEntity.ok(flightService.saveFlight(flight));
    }
*/

}
