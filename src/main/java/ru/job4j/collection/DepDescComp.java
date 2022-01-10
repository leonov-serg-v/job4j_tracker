package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //String[] listEl1 = o1.split("/");
        //String[] listEl2 = o2.split("/");
        int result = o2.split("/")[0].compareTo(o1.split("/")[0]);
        if (result == 0) {
            result = o1.compareTo(o2);
        }

        /*
        for (String el : o1.split("/")) {

        }

         */
        return result;
    }
}