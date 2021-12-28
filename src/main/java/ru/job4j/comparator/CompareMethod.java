package ru.job4j.comparator;

public class CompareMethod {

    public static int ascendingCompare(int first, int second) {
        if (first < second) {
            return -1;
        } else {
            if (first > second) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static int descendingCompare(int first, int second) {
        if (first < second) {
            return 1;
        } else {
            if (first > second) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
