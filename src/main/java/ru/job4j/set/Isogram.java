package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<String> chars = new HashSet<>();
        chars.addAll(Arrays.asList(s.split("")));
        return chars.size() == s.length();
    }
}
