package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String item = "";
        if (!list.isEmpty()) {
            item = list.remove(list.size() - 1);
        }
        if (list.size() > index) {
            list.set(index, item);
        }
        return list;
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
        list.add("nine");
        int index = 20;
        List<String> result = RepositionElement.changePosition(list, index);
    }
}
