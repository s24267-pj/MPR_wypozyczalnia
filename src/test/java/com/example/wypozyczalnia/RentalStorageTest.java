package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RentalStorageTest {
    private RentalStorage rentalStorage = new RentalStorage();


    @Test
    void test() {

        //GIVEN
        String vin = "acf";

        //WHEN


        List<Rental> rentalList = rentalStorage.getRentalList();
        boolean wynajety = false;
        for (Rental rental : rentalList) {
            if (rental.getCar().getVin().equals(vin)) {
                wynajety = true;
                break;
            }
        }

        //THEN
        Assertions.assertFalse(wynajety, "Samochód jest wynajęty");
    }

}
