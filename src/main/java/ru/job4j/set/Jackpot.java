package ru.job4j.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> setCombination = new TreeSet<>();
        setCombination.addAll(Arrays.asList(combination));
        return setCombination.size() == 1;
    }

}
