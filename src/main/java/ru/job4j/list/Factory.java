package ru.job4j.list;

import java.util.List;

import static java.util.List.of;

public class Factory {
    public static void main(String[] args) {
        List<String> list = of("first", "second", "third", "fourth", "fifth");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
