package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items[i] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int sizeResult = 0;
        Item item;
        for (int i = 0; i < size; i++) {
             item = items[i];
             if (item.getName().equals(key)) {
                 result[sizeResult++] = item;
             }
        }
        return Arrays.copyOf(result, sizeResult);
    }

    public boolean replace(int id, Item anotherItem) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            anotherItem.setId(id);
            items[i] = anotherItem;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            System.arraycopy(items, i + 1, items, i, size - i - 1);
            items[size] = null;
            size--;
        }
        return rsl;
    }
}