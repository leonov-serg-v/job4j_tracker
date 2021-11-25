package ru.job4j.tracker;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item anotherItem) {
        return tracker.replace(id, anotherItem);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public static void main(String[] args) {
        SingleTracker st = SingleTracker.getInstance();
        st.add(new Item("123"));
        System.out.println(st.findById(1));
    }
}
