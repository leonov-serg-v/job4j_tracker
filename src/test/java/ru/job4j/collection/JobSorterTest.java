package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobSorterTest {

    @Test
    public void sortJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("2Impl task", 2),
                new Job("4Fix bugs", 4),
                new Job("8Reboot server", 8),
                new Job("9Reboot server", 1)

        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("8Reboot server", 8),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("2Impl task", 2),
                new Job("4Fix bugs", 4),
                new Job("8Reboot server", 8)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("8Reboot server", 8),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 2),
                new Job("9Reboot server", 1)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobDescByPriorityDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobDescByPriority().thenComparing(new JobDescByName()));
        List<Job> expected = Arrays.asList(
                new Job("8Reboot server", 8),
                new Job("2Impl task", 8),
                new Job("4Fix bugs", 4),
                new Job("9Reboot server", 1)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobAscByPriorityAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobAscByPriority().thenComparing(new JobAscByName()));
        List<Job> expected = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobAscByPriorityDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobAscByPriority().thenComparing(new JobDescByName()));
        List<Job> expected = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("8Reboot server", 8),
                new Job("2Impl task", 8)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobDescByPriorityAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("9Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobDescByPriority().thenComparing(new JobAscByName()));
        List<Job> expected = Arrays.asList(
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8),
                new Job("4Fix bugs", 4),
                new Job("9Reboot server", 1)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobDescByNameAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("8Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobDescByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("8Reboot server", 1),
                new Job("8Reboot server", 8),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void sortJobAscByNameDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("8Reboot server", 1),
                new Job("4Fix bugs", 4),
                new Job("2Impl task", 8),
                new Job("8Reboot server", 8)
        );
        jobs.sort(new JobAscByName().thenComparing(new JobDescByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("2Impl task", 8),
                new Job("4Fix bugs", 4),
                new Job("8Reboot server", 8),
                new Job("8Reboot server", 1)
        );
        assertThat(jobs, is(expected));
    }

}