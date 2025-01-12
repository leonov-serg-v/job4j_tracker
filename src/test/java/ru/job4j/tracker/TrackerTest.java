package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item result = tracker.findByName(second.getName()).get(1);
        assertThat(result.getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDeleteOne() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteSecond() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug-1");
        tracker.add(bug);
        bug = new Item();
        bug.setName("Bug-2");
        tracker.add(bug);
        int id = bug.getId();
        bug = new Item();
        bug.setName("Bug-3");
        tracker.add(bug);
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteLast() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug-1");
        tracker.add(bug);
        bug = new Item();
        bug.setName("Bug-2");
        tracker.add(bug);
        bug = new Item();
        bug.setName("Bug-3");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void sortItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("2-Second"),
                new Item("5-Five"),
                new Item("1-First")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("1-First"),
                new Item("2-Second"),
                new Item("5-Five")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void sortItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "2-Second"),
                new Item(2, "5-Five"),
                new Item(3, "1-First")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "5-Five"),
                new Item(1, "2-Second"),
                new Item(3, "1-First")
        );
        assertThat(items, is(expected));
    }

}