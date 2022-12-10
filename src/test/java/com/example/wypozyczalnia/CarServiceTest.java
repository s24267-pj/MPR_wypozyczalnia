package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CarServiceTest {

    private final CarStorage carStorage = new CarStorage();
    private final RentalStorage rentalStorage = new RentalStorage();
    private final CarService carService = new CarService(carStorage, rentalStorage);





    @Test
    void testStartToEndDate(){
        String vin = "aabbcc";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12,15);

        RentalInfo rentalInfo = carService.rentCar(new User("polik"), vin, startDate, endDate);

        Assertions.assertNull(rentalInfo);

    }




}
