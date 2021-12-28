package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        int index = list.indexOf(el);
        int indexLast = list.lastIndexOf(el);
        if (list.indexOf(el) == -1 || index == indexLast) {
            return new ArrayList<String>();
        }
        return list.subList(index, indexLast);

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("three");
        list.add("ten");
        List<String> result = SubList.getElementsBetweenIndexes(list, "five");
        List<String> expected = List.of("three", "four", "five", "six", "seven", "eight");
        System.out.println(result.toString());
    }
}
