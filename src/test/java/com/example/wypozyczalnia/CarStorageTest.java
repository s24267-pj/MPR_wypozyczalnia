package com.example.wypozyczalnia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;


import java.util.ArrayList;
import java.util.List;

public class CarStorageTest {
    private CarStorage carStorage = new CarStorage();

    private Car fordMondeo = new Car("ford", "mondeo", "aabbcc", CarType.STANDARD);
    private Car volkswagenTouareg = new Car("volkswagen", "touareg", "ddeeff", CarType.PREMIUM);
    private Car fordExplorer = new Car("ford", "explorer", "abc", CarType.PREMIUM);
    private Car bentleyArnage = new Car("bentley", "arnage", "ghj", CarType.STANDARD);
    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public void CarStorage() {
        carList.add(fordMondeo);
        carList.add(volkswagenTouareg);
        carList.add(fordExplorer);
        carList.add(bentleyArnage);
    }

    public String findVin(String vin) {
        for (Car car : carList) {
            if (car.getVin().equals(vin)) {
                return car.getVin();
            }
        }
        return null;
    }

    public Car findCar(String vin) {
        for (Car car : carList) {
            if (car.getVin().equals(vin)) {
                return carList.get(carList.indexOf(car));
            }
        }
        return null;
    }
@Test
    void Test() {
        //GIVEN
        String vin = "zzzz";

        //WHEN
        Car car = carStorage.findCar(vin);


        //THEN
        Assertions.assertNotNull(car, "Brak VIN w CarStorage.");
    }
}
