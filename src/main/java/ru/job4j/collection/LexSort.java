package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String rigth) {
        String[] wordLeft = left.split("\\.");
        String[] wordRigth = rigth.split("\\.");
        return Integer.compare(Integer.parseInt(wordLeft[0]), Integer.parseInt(wordRigth[0]));
    }
}
