package ru.job4j.list;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        int summ = first;
        int prev = first;
        for (int i = 2; i < count + 1; i++) {
            prev = prev * denominator;
            summ += prev;
        }
        return summ;
    }
}
