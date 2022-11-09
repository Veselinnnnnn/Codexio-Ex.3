package com.codexio.ex3;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<CarEntity> findAllCars(){
        return carRepository.findAll();
    }

    public CarEntity createCar(CarDto carDto){
        CarEntity newCar = new CarEntity();

        newCar.setBrand(carDto.getBrand());
        newCar.setHp(carDto.getHp());
        newCar.setModel(carDto.getModel());
        newCar.setType(carDto.getType());
        newCar.setAvailable(true);

        return this.carRepository.save(newCar);
    }

    public CarEntity editCar(CarDto carDto){
        CarEntity currentCar = new CarEntity();

        currentCar.setId(carDto.getId());
        currentCar.setBrand(carDto.getBrand());
        currentCar.setHp(carDto.getHp());
        currentCar.setModel(carDto.getModel());
        currentCar.setType(carDto.getType());
        currentCar.setAvailable(true);

        return this.carRepository.save(currentCar);
    }

    public boolean isCarAvailable(Long carId){
        CarEntity carToCheck = new CarEntity();
        carToCheck = carRepository.findCarById(carId);
        return carToCheck.isAvailable();
    }

    public CarEntity rentCarIfAvailable(Long carId){
        CarEntity carToCheck = new CarEntity();
        carToCheck = carRepository.findCarById(carId);
        if(carToCheck.isAvailable()){
            carToCheck.setAvailable(false);
            carRepository.save(carToCheck);
            return carToCheck;
        }else{
            throw new IllegalArgumentException("Car is not available!");
        }
    }
}
