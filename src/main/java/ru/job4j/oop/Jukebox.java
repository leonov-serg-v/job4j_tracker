package ru.job4j.oop;

public class Jukebox {
    @SuppressWarnings("checkstyle:NeedBraces")
    public void music(int position) {
        String song = "Песня не найдена";
        if (position == 1) {
            song = "Пусть бегут неуклюже";
        } else if (position == 2) {
            song = "Спокойной ночи";
        }
        System.out.println("Звучит песня :" + song);
    }

    public static void main(String[] args) {
        Jukebox box = new Jukebox();
        box.music(1);
        box.music(2);
        box.music(0);
    }
}
