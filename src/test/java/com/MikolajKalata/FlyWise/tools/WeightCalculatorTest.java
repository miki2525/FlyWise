package com.MikolajKalata.FlyWise.tools;

import com.MikolajKalata.FlyWise.model.Baggage;
import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.model.Cargoes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeightCalculatorTest {

    @Mock
    private Cargo cargoTest;


    @Test
    void getBaggageTotalWeight() {
        //
        List<Baggage> baggageListTest = new ArrayList<>();
        baggageListTest.add(new Baggage(200, "lb", 350, cargoTest));
        baggageListTest.add(new Baggage(350, "lb", 999, cargoTest));
        baggageListTest.add(new Baggage(600, "kg", 675, cargoTest));
        //
        Integer sumBag = WeightCalculator.getBaggageTotalWeight(baggageListTest);
        //
        assertThat(sumBag).isEqualTo(848);
    }

    @Test
    void getCargoesTotalWeight() {
        //
        List<Cargoes> cargoesListTest = new ArrayList<>();
        cargoesListTest.add(new Cargoes(100, "kg", 100, cargoTest));
        cargoesListTest.add(new Cargoes(200, "lb", 25, cargoTest));
        //
        Integer sumCarg = WeightCalculator.getCargoesTotalWeight(cargoesListTest);
        //
        assertThat(sumCarg).isEqualTo(190);
    }
}