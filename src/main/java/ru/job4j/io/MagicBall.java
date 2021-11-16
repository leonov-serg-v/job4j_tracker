package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    private static String getAnswer() {
        int answer = new Random().nextInt(3);
        String result;
        switch (answer) {
            case (0) :
                result = "Да";
                break;
            case (1) :
                result = "Нет";
                break;
            default:
                result = "Может быть";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что Вы хотите узнать?");
        String question = input.nextLine();
        System.out.println(getAnswer());
    }
}
