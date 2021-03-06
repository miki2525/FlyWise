package com.MikolajKalata.FlyWise.tools;

public class AirportDetails {

    private Long numOfFlightDep;
    private Long numOfFlightArr;
    private Long totalNumOfBaggDep;
    private Long totalNumOfBaggArr;

    public AirportDetails(Long numOfFlightDep, Long numOfFlightArr, Long totalNumOfBaggDep, Long totalNumOfBaggArr) {
        this.numOfFlightDep = numOfFlightDep;
        this.numOfFlightArr = numOfFlightArr;
        this.totalNumOfBaggDep = totalNumOfBaggDep;
        this.totalNumOfBaggArr = totalNumOfBaggArr;
    }

    public static boolean validate(Long numOfFlightDep, Long numOfFlightArr, Long totalNumOfBaggDep, Long totalNumOfBaggArr){
        if(numOfFlightDep == null ||
                numOfFlightArr == null ||
                totalNumOfBaggDep == null ||
                totalNumOfBaggArr == null){
            return false;
        }
        else if(numOfFlightArr == 0L && numOfFlightDep == 0L && totalNumOfBaggArr == 0 && totalNumOfBaggDep == 0){
            return false;
        }
        else { return true;}

    }
    public Long getNumOfFlightDep() {
        return numOfFlightDep;
    }

    public void setNumOfFlightDep(Long numOfFlightDep) {
        this.numOfFlightDep = numOfFlightDep;
    }

    public Long getNumOfFlightArr() {
        return numOfFlightArr;
    }

    public void setNumOfFlightArr(Long numOfFlightArr) {
        this.numOfFlightArr = numOfFlightArr;
    }

    public Long getTotalNumOfBaggDep() {
        return totalNumOfBaggDep;
    }

    public void setTotalNumOfBaggDep(Long totalNumOfBaggDep) {
        this.totalNumOfBaggDep = totalNumOfBaggDep;
    }

    public Long getTotalNumOfBaggArr() {
        return totalNumOfBaggArr;
    }

    public void setTotalNumOfBaggArr(Long totalNumOfBaggArr) {
        this.totalNumOfBaggArr = totalNumOfBaggArr;
    }

    @Override
    public String toString() {
        return "AirportDetails{" +
                "numOfFlightDep=" + numOfFlightDep +
                ", numOfFlightArr=" + numOfFlightArr +
                ", totalNumOfBaggDep=" + totalNumOfBaggDep +
                ", totalNumOfBaggArr=" + totalNumOfBaggArr +
                '}';
    }
}
