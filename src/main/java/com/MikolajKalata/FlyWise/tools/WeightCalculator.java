package com.MikolajKalata.FlyWise.tools;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargoes;


import java.util.List;


public class WeightCalculator{

    public static Integer getBaggageTotalWeight(List<Baggage> baggageList) {
            Integer baggageTotal = 0;
        for (Baggage baggageTemp : baggageList){
            if (baggageTemp.getWeightUnit().equals("lb")){
                baggageTemp.setWeight(WeightConverter.lbsToKgs(baggageTemp.getWeight()));    //////kg is a default unit
            }

            baggageTotal += baggageTemp.getWeight();

        }

        return baggageTotal;
    }

    public static Integer getCargoesTotalWeight(List<Cargoes> cargoesList) {
            Integer cargoesTotal = 0;
        for (Cargoes cargoesTemp : cargoesList){
            if (cargoesTemp.getWeightUnit().equals("lb")){
                cargoesTemp.setWeight(WeightConverter.lbsToKgs(cargoesTemp.getWeight()));    //////kg is a default unit
            }

            cargoesTotal += cargoesTemp.getWeight();

        }

        return cargoesTotal;
    }
}
