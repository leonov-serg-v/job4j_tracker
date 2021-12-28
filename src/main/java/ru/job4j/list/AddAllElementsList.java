package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        if (left.indexOf(str) != -1 && right.indexOf(str) != -1) {
            left.remove(str);
        }
        left.addAll(right);
        return left.indexOf(str);
    }

    public static void main(String[] args) {
        List<String> left = new ArrayList<>();
        left.add("first");
        left.add("second");
        left.add("third");
        List<String> right = new ArrayList<>();
        right.add("fourth");
        right.add("second");
        right.add("fifth");
        String check = "second";
        int result = AddAllElementsList.containsElement(left, right, check);
        System.out.println(result);
    }
}
