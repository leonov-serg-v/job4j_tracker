package ru.job4j.collection;

import ru.job4j.collection.Job;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("9Reboot server", 10),
                new Job("9Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        jobs.sort(new SortByNameJob());
        System.out.println(jobs);
    }
}
