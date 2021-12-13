package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items.get(i) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
             if (item.getName().equals(key)) {
                 result.add(item);
             }
        }
        return result;
    }

    public boolean replace(int id, Item anotherItem) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            anotherItem.setId(id);
            items.remove(i);
            items.add(anotherItem);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            items.remove(i);
        }
        return rsl;
    }
}