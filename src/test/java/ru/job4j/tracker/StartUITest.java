package ru.job4j.tracker;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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

    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Add item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "Edit item"
        };
        Input input = new StubInput(answer);
        StartUI.editItem(input, tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is(answer[1]));
    }

    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Add item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
        };
        Input input = new StubInput(answer);
        StartUI.deleteItem(input, tracker);
        Item deteted = tracker.findById(item.getId());
        assertThat(deteted, is(nullValue()));
    }
}