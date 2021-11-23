package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenPrintAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new PrintAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                    + "0. Show all items" + ln
                    + "1. Exit Program" + ln
                    + "=== Show all items ===" + ln
                    + item + ln
                    + "Menu." + ln
                    + "0. Show all items" + ln
                    + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "=== Find item by id ===" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        tracker.add(new Item("Second item"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
                + "=== Find items by name ===" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
        ));
    }
}