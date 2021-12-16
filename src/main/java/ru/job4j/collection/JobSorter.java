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
                new Job("8Reboot server", 8),
                new Job("9Reboot server", 1)
        );
        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
    }
}
