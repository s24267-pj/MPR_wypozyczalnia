package com.example.wypozyczalnia;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CarService {
    private final Storage magazynSamochodow;
    private final RentalStorage rentalStorage;


    public CarService(Storage magazynSamochodow, RentalStorage rentalStorage) {
        this.magazynSamochodow = magazynSamochodow;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return magazynSamochodow.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }

    private double calculation(long days, CarType carType) {
        double basePrice = 10;
        double mnoznik = 10.5;

        if (carType.equals(CarType.STANDARD)) {
            return days * basePrice;
        } else {
            return days * basePrice * mnoznik;
        }
    }


    //zwroc RentalInfo
    //do parametrow dodac LocalDate, StartDate, EndDate
    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = magazynSamochodow.findCar(vin);
        List<Rental> rentalList = rentalStorage.getRentalList();
        for (Rental rental : rentalList) {
            if (rental.getCar().getVin().equals(car.getVin())) {
                System.out.println("Jest zarezerwowany.");
            } else {
                rentalStorage.getRentalList().add(new Rental(user, car));
                System.out.println("Uzytkownik: " + user.getUser() + " wynajal: " + vin + "(" + car.getKlasaSamochodu() + ")");
                System.out.println("Ilosc dni: " + ChronoUnit.DAYS.between(startDate, endDate));
                System.out.println("Cena: " + calculation(ChronoUnit.DAYS.between(startDate, endDate), car.getKlasaSamochodu()));
                return null;
            }
            //return new RentalInfo(price, startDate, endDate);
        }

        return null;
    }


//dodac metode rentCar
//Sprawdzic czy istneje samchod z podanym vin
//jak tak to wynajmij
//jak nie to zwroc null
//wypisz na ekran tylko gdy uda sie wynajac
//
}
