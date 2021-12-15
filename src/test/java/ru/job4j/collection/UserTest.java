package ru.job4j.collection;

import org.junit.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("1Petr", 32));
        users.add(new User("3Ivan", 33));
        users.add(new User("3Ivan", 3));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("1Petr", 32)));
        assertThat(it.next(), is(new User("3Ivan", 3)));
        assertThat(it.next(), is(new User("3Ivan", 33)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareIvanVSIvanGreater() {
        int rsl = new User("Ivan", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareIvanVSIvanLess() {
        int rsl = new User("Ivan", 2)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, lessThan(0));
    }

}