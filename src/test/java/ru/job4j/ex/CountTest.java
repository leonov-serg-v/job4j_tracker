package ru.job4j.ex;

import org.junit.Test;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        int result = Count.add(10, 2);
    }
}