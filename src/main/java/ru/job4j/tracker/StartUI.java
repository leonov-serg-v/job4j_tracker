package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    private Scanner scanner;
    private Tracker tracker;

    public void init(Scanner scanner, Tracker tracker) {
        this.scanner = scanner;
        this.tracker = tracker;
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0 :
                    addItem();
                    break;
                case 1 :
                    printAllItem();
                    break;
                case 2 :
                    editItem();
                    break;
                case 6 :
                    run = false;
                    break;
                default:
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    private void addItem() {
        System.out.println("=== Create a new Item ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    private void printAllItem() {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Хранилище не содержит заявок");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("Количество заявок: " + items.length);
    }

    private void editItem() {
        System.out.println("=== Edit item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
