package ru.job4j.tracker;

public class PrintAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            tracker.printItems(items);
        } else {
            System.out.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}
