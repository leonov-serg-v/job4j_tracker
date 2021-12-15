package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJob implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        int result = first.getName().compareTo(second.getName());
        if (result == 0) {
            result = Integer.compare(first.getPriority(), second.getPriority()) * -1;
        }
        return result;
    }
}
