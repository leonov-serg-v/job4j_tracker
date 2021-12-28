package ru.job4j.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Pangram {
    public static boolean checkString(String s) {
        String[] words = s.split(" ");
        Set<String> setChar = new TreeSet<>();
        for (String w : words) {
            String[] chars = w.split("");
            setChar.addAll(Arrays.asList(chars));
        }
        return setChar.size() == 26;
    }
}
