package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 201);
        Book book2 = new Book("Война и мир", 701);
        Book book3 = new Book("Молодая гвардия", 231);
        Book book4 = new Book("Когда исчезает страх", 534);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        Book book;
        System.out.println("Список книг");
        for (int i = 0; i < library.length; i++) {
            book = library[i];
            System.out.println("Книга : " + book.getName() + " страниц :" + book.getCountPage());
        }
        book = library[0];
        library[0] = library[3];
        library[3] = book;
        System.out.println("Список книг после перестановки");
        for (int i = 0; i < library.length; i++) {
            book = library[i];
            System.out.println("Книга : " + book.getName() + " страниц :" + book.getCountPage());
        }
        System.out.println("Список книг с названием Clean code");
        for (Book b : library) {
            if ("Clean code".equals(b.getName()))  {
                System.out.println("Книга : " + b.getName() + " страниц :" + b.getCountPage());
            }
        }
    }
}
