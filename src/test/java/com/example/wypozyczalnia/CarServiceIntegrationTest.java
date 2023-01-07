package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarServiceIntegrationTest {

    @MockBean
    private CarStorage carStorage;
    @MockBean
    private RentalStorage rentalStorage;
    @Autowired
    private CarService carService;

    @Test
    void shouldNotFindCar() {
        when(carStorage.getCarList()).thenReturn(List.of(new Car("Ford", "Mondeo", "aarr", CarType.PREMIUM)));
        assertThat(carStorage.findCar("aa")).isNull();

    }

    @Test
    void shouldNotRentCar_AlreadyRented() {
        when(rentalStorage.getRentalList()).thenReturn(List.of(new Rental(new User("Damian"), (new Car("Ford", "Mondeo", "aarr", CarType.PREMIUM)))));
        assertThat()
    }


    @Test
    void testStartToEndDate() {
        String vin = "ddeeff";
        LocalDate startDate = LocalDate.of(2022, 12, 15);
        LocalDate endDate = LocalDate.of(2022, 12, 10);

        RentalInfo rentalInfo = carService.rentCar(new User("polik"), vin, startDate, endDate);


        assertThat(rentalInfo.equals(null));

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
