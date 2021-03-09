package com.MikolajKalata.FlyWise.tools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AirportDetailsTest {

    @Test
    void validate() {
        //
        Long l1 = 10l;
        Long l2 = 20l;
        Long l3 = null;
        Long l4 = 40l;
        //
        boolean check = AirportDetails.validate(l1, l2, l3, l4);
        //
        Assertions.assertThat(check).isFalse();
        Assertions.assertThat(l3).isNull();
    }
}