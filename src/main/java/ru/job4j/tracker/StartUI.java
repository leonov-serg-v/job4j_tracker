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
                    printAllItems();
                    break;
                case 2 :
                    editItem();
                    break;
                case 3 :
                    deleteItem();
                    break;
                case 4 :
                    findByIdItem();
                    break;
                case 5 :
                    findByNameItem();
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

    private void printAllItems() {
        Item[] items = tracker.findAll();
        printItems(items);
    }

    private void printItems(Item[] items) {
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

    private void deleteItem() {
        System.out.println("=== Delete item ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    private void findByIdItem() {
        System.out.println("=== Find item by id ===");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
    }

    private void findByNameItem() {
        System.out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            printItems(items);
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
