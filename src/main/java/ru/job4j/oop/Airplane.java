package ru.job4j.oop;

public class Airplane implements Vehicle {
    private String name;

    public Airplane() {
    }

    public Airplane(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass() + " " + this.name + " Передвигается по воздуху");
    }
}
