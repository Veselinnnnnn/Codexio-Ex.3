package com.codexio.ex3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<List<CarEntity>> getAllCars(){
        List<CarEntity> cars = carService.findAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<CarEntity> createCar(@RequestBody CarDto carDto){
        return new ResponseEntity<>(this.carService.createCar(carDto),HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "")
    public ResponseEntity<CarEntity> editCar(@RequestBody CarDto carDto){
        return new ResponseEntity<>(this.carService.editCar(carDto),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rent/{id}")
    public ResponseEntity<CarEntity> rentCarIfAvailable(@PathVariable("id")Long id){
        return new ResponseEntity<>(this.carService.rentCarIfAvailable(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/isAvailable/{id}")
    public ResponseEntity<Boolean> checkIfIsAvailable(@PathVariable("id")Long id){
        return new ResponseEntity<>(this.carService.isCarAvailable(id), HttpStatus.OK);
    }


}
