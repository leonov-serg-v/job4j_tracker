package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Bus busA = new Bus("A");
        Bus busB = new Bus("B");
        Airplane airplaneA = new Airplane("A");
        Airplane airplaneB = new Airplane("B");
        Train trainA = new Train("A");
        Train trainB = new Train("B");

        Vehicle[] vehicles = new Vehicle[]{busA, busB, airplaneA, airplaneB, trainA, trainB};
        for (Vehicle v : vehicles) {
            v.move();
        }

    }
}
