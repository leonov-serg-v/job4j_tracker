package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenTwoOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("yg5d", "DressBig"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("yg5d"), is(new Order("yg5d", "DressBig")));
    }

    @Test
    public void whenDublOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("yg5d", "DressBig"));
        orders.add(new Order("yg5d", "DressBig"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int expected = 2;
        assertThat(map.size(), is(expected));
    }

}
