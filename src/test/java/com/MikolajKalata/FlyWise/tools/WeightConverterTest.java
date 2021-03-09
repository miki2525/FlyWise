package com.MikolajKalata.FlyWise.tools;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WeightConverterTest {

    @Test
    void lbsToKg() {
        //
        Integer testNum = WeightConverter.lbsToKgs(100);
        //
        //
        assertThat(testNum).isEqualTo(45);
    }

    @Test
    void kgToLbs() {
        //
        Integer testNum = WeightConverter.kgsToLbs(100);
        //
        //
        assertThat(testNum).isEqualTo(220);
    }
}