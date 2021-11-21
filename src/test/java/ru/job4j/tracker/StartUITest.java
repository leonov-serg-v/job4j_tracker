package ru.job4j.tracker;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest extends TestCase {

    public void testCreateItem() {
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(answer[0]);
        assertThat(created.getName(), is(expected.getName()));
    }
}