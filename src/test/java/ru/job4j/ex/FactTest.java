package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test
    public void testCalc3() {
        Fact fact = new Fact();
        int result = fact.calc(3);
        int expected = 6;
        assertThat(expected, is(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcEx() {
        Fact fact = new Fact();
        int result = fact.calc(-3);
    }
}