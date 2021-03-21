package com.MikolajKalata.FlyWise.service;

import com.MikolajKalata.FlyWise.model.Cargo;
import com.MikolajKalata.FlyWise.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    private CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public Cargo saveCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public List<Cargo> saveCargoList(List<Cargo> cargoList){
        return cargoRepository.saveAll(cargoList);
    }
}
