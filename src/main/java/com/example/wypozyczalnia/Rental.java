package com.example.wypozyczalnia;

public class Rental {
    private User user;
    private Car car;

    public Rental(User user, Car car) {
        this.user = user;
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }
}
