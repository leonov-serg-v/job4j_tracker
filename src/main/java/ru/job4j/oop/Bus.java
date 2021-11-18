package ru.job4j.oop;

public class Bus implements Vehicle {
    private String name;

    public Bus() {
    }

    public Bus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(getClass() + " " + this.name + " Передвигается по трасам");
    }
}
