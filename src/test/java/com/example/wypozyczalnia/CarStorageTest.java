package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CarStorageTest {
    private CarStorage carStorage = new CarStorage();

@Test
    void shouldNotFindCar() {
        //GIVEN
        String vin = "zzzz";

        //WHEN
        Car car = carStorage.findCar(vin);


        //THEN
        Assertions.assertNotNull(car, "Brak VIN w CarStorage.");
    }
}
