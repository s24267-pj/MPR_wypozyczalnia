package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceMockTest {
    @Mock
    private CarStorage carStorage;
    @Mock
    private RentalStorage rentalStorage;
    @Mock
    private User user;

    @InjectMocks
    private CarService carService;

    @Test
    void shouldMockCarStorage() {
        when(carStorage.getCarList()).thenReturn(List.of(new Car("ford", "mondeo", "abc", CarType.STANDARD)));
        assertThat(carService.getAllCars()).isNotNull();
    }

    @Test
    void shouldNotFindCar() {
         //vin = null;

        // RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        when(carStorage.findCar(any())).thenReturn(null);
        assertThat(carService.getAllCars()).isNull();


    }
}
