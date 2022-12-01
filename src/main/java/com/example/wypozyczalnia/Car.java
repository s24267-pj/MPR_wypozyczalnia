package com.example.wypozyczalnia;

public class Car {
    private String marka;
    private String model;
    private String vin;
    private CarType klasaSamochodu;


    public Car(String marka, String model, String vin, CarType klasaSamochodu) {
        this.marka = marka;
        this.model = model;
        this.vin = vin;
        this.klasaSamochodu = klasaSamochodu;

    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public CarType getKlasaSamochodu() {
        return klasaSamochodu;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", klasaSamochodu=" + klasaSamochodu +
                '}';
    }
}
