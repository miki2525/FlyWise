package com.MikolajKalata.FlyWise.tools;

public class Weights {

    private Integer totalBaggage;
    private Integer totalCargo;
    private Integer totalWeight;

    public Weights(Integer totalBaggage, Integer totalCargo, Integer totalWeight) {
        this.totalBaggage = totalBaggage;
        this.totalCargo = totalCargo;
        this.totalWeight = totalWeight;
    }

    public void setTotalBaggage(Integer totalBaggage) {
        this.totalBaggage = totalBaggage;
    }

    public void setTotalCargo(Integer totalCargo) {
        this.totalCargo = totalCargo;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getTotalBaggage() {
        return totalBaggage;
    }

    public Integer getTotalCargo() {
        return totalCargo;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Weights{" +
                "totalBaggage=" + totalBaggage +
                ", totalCargo=" + totalCargo +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
