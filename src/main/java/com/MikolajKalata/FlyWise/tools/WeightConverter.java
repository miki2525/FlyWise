package com.MikolajKalata.FlyWise.tools;

public interface WeightConverter {

    static Integer lbsToKg(Integer lbs){
         Double sum = lbs * 0.45359237;
         return sum.intValue();
    }

    static Integer kgToLbs(Integer kg){
        Double sum = kg * 2.20462262;
        return sum.intValue();
    }
}
