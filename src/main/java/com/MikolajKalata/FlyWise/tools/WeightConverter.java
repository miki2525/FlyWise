package com.MikolajKalata.FlyWise.tools;

public class WeightConverter {

    private final static double toKgs = 0.45359237;
    private final static double toLbs = 2.20462262;

    static Integer lbsToKgs(Integer lbs){
         Double sum = lbs * toKgs;
         return sum.intValue();
    }

    static Integer kgsToLbs(Integer kgs){
        Double sum = kgs * toLbs;
        return sum.intValue();
    }

}
