package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public  Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность : " + this.active);
        System.out.println("Статус : " + this.status);
        System.out.println("Сообщение : " + this.message);
    }

    public static void main(String[] args) {
        Error errDefault = new Error();
        errDefault.printInfo();
        Error err1 = new Error(true, 1, "Описание ошибки со статусом 1");
        err1.printInfo();
        Error err2 = new Error(false, 2, "Описание ошибки со статусом 2");
        err2.printInfo();
        Error err3 = new Error(true, 3, "Описание ошибки со статусом 3");
        err3.printInfo();

    }
}
