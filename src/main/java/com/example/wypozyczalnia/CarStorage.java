package com.example.wypozyczalnia;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {

    private Car fordMondeo = new Car("ford", "mondeo", "aabbcc", CarType.STANDARD);
    private Car volkswagenTouareg = new Car("volkswagen", "touareg", "ddeeff", CarType.PREMIUM);
    private Car fordExplorer = new Car("ford", "explorer", "abc", CarType.PREMIUM);
    private Car bentleyArnage = new Car("bentley", "arnage", "ghj", CarType.STANDARD);
    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public CarStorage() {
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
}
