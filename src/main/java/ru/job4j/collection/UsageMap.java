package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mails = new HashMap<>();
        mails.put("leonov.serg.v@gmail.com", "Леонов Сергей");
        mails.put("leonov.serg.v@gmail.com", "Леонов Сергей Валентинович");
        for (String key : mails.keySet()) {
            String value = mails.get(key);
            System.out.println("Key = " + key + " Value = " + value);
        }
    }
}
