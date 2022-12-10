package com.example.wypozyczalnia;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;


    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }

    private double calculation(long days, CarType carType) {
        double basePrice = 10;
        double multiplier = 10.5;

        if (carType.equals(CarType.STANDARD)) {
            return days * basePrice;
        } else {
            return days * basePrice * multiplier;
        }
    }

    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.findCar(vin);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        List<Rental> rentalList = rentalStorage.getRentalList();

        if (car == null) {
            System.out.println("Numer VIN nie istnieje.");
            return null;
        }

        if (days < 0) {
            System.out.println("startDate jest wieksze od endDate.");
            return null;
        }

        boolean wynajety = false;
        for (Rental rental : rentalList) {
            if (rental.getCar().getVin().equals(car.getVin())) {
                wynajety = true;

                break;
            }
        }

        if (wynajety) {
            System.out.println("Już jest zarezerwowany.");
        } else {
            rentalStorage.getRentalList().add(new Rental(user, car));
            System.out.println("Uzytkownik: " + user.getUser() + " wynajal: " + vin + "(" + car.getKlasaSamochodu() + ")");
            System.out.println("Ilosc dni: " + days);
            System.out.println("Cena: " + calculation(days, car.getKlasaSamochodu()));
        }

        /*for (Rental rental : rentalList) {
            if (rental.getCar().getVin().equals(car.getVin())) {
                System.out.println("Już jest zarezerwowany.");
               break;
            } else {
                rentalStorage.getRentalList().add(new Rental(user, car));
                System.out.println("Uzytkownik: " + user.getUser() + " wynajal: " + vin + "(" + car.getKlasaSamochodu() + ")");
                System.out.println("Ilosc dni: " + ChronoUnit.DAYS.between(startDate, endDate));
                System.out.println("Cena: " + calculation(ChronoUnit.DAYS.between(startDate, endDate), car.getKlasaSamochodu()));
                break;
            }*/
        return new RentalInfo(calculation(days, car.getKlasaSamochodu()), startDate, endDate);


        //return null;
    }
}
