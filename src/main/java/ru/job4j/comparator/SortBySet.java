package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortBySet {
    public static Set<String> sort(List<String> list) {
        Set<String> set = new TreeSet<>();
        set.addAll(list);
        return set;
    }
}
