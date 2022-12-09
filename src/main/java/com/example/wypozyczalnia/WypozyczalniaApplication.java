package com.example.wypozyczalnia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class WypozyczalniaApplication {
    private final CarService carService;

    public WypozyczalniaApplication(CarService carService) {
        this.carService = carService;

        carService.rentCar(new User("polik"), "ddeeff", LocalDate.now(), LocalDate.of(2022,12,10));
        //carService.rentCar(new User("jan"), "ddeeff", LocalDate.now(), LocalDate.of(2022,12,15));

    }

    public static void main(String[] args) {
        SpringApplication.run(WypozyczalniaApplication.class, args);
    }

}
