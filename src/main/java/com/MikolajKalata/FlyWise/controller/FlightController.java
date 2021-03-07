package com.MikolajKalata.FlyWise.controller;

import com.MikolajKalata.FlyWise.model.Flight;
import com.MikolajKalata.FlyWise.service.FlightService;
import com.MikolajKalata.FlyWise.tools.WeightCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/")
public class FlightController {
    private FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @GetMapping
    public String index(){
        return "index";
    }

}
