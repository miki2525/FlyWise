package com.MikolajKalata.FlyWise.tools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WeightConverterTest {

    @Test
    void lbsToKg() {
        //
        Integer testNum = WeightConverter.lbsToKg(100);
        //
        //
        assertThat(testNum).isEqualTo(45);
    }

    @Test
    void kgToLbs() {
        //
        Integer testNum = WeightConverter.kgToLbs(100);
        //
        //
        assertThat(testNum).isEqualTo(220);
    }
}