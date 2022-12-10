package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

public class CarServiceTest {

    private final CarStorage carStorage = new CarStorage();

    private final RentalStorage rentalStorage = new RentalStorage();

    private final CarService carService = new CarService(carStorage, rentalStorage);
    private CarType carType;


    @Test
    void shouldNotFindCar() {

        User user = new User("asdasds");
        String vin = "zzz";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12, 15);


        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);
        // carService.rentCar(user, vin, startDate, endDate);

        //assertThat(rentalStorage.getRentalList())has.
        Assertions.assertNull(rentalInfo, "FAILED: VIN jest w CarStorage.");
    }

    @Test
    void shouldNoRentCar_AlreadRented() {
        RentalInfo rentalInfo = carService.rentCar(new User("aaa"),
                "ddeeff",
                LocalDate.of(2022, 12, 1),
                LocalDate.of(2022, 12, 10));


        //THEN
        Assertions.assertNull(rentalInfo, "FAILED: auto zostało juz zarezerwowane.");
    }


    @Test
    void testStartToEndDate() {
        String vin = "aabbcc";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12, 15);

        RentalInfo rentalInfo = carService.rentCar(new User("polik"), vin, startDate, endDate);

        Assertions.assertNull(rentalInfo);

    }

    @Test
    void shouldRentPremiumCar() {
        User user = new User("asdasds");
        String vin = "aabbcc";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12, 15);

        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        assertThat(rentalInfo.getPrice()).isEqualTo(50);
    }

}
