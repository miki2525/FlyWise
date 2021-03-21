package com.MikolajKalata.FlyWise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq", initialValue = 0)
public class Cargoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private Integer weight;

    private String weightUnit;

    private Integer pieces;

    @JoinColumn(name = "cargo_flightId")
    @ManyToOne
    @JsonIgnore
    private Cargo cargo;


    public Cargoes() {
    }

    public Cargoes(Integer weight, String weightUnit, Integer pieces, Cargo cargo) {
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargoes cargoes = (Cargoes) o;
        return Objects.equals(weight, cargoes.weight) && Objects.equals(weightUnit, cargoes.weightUnit) && Objects.equals(pieces, cargoes.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight*7, weightUnit, pieces*11);
    }

    @Override
    public String toString() {
        return "Cargoes{" +
                "id=" + id +
                ", weight=" + weight +
                ", weightUnit='" + weightUnit + '\'' +
                ", pieces=" + pieces +
                ", cargo=" + cargo +
                '}';
    }
}
