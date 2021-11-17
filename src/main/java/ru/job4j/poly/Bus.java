package ru.job4j.poly;

public class Bus implements Transport {
    private int countPassengers;

    @Override
    public void drive() {
        System.out.println("Едем");
    }

    @Override
    public void passengers(int count) {
        this.countPassengers = count;
    }

    @Override
    public double refuel(int fuel) {
        return fuel * 46.32;
    }
}
