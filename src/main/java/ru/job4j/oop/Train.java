package ru.job4j.oop;

public class Train implements Vehicle {
    private String name;

    public Train() {
    }

    public Train(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass() + " " + this.name + " Передвигается по рельсам");
    }
}
