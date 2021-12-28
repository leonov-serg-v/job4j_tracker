package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String s : strings) {
            String key = s.charAt(0) + "";
            rsl.putIfAbsent(key, new ArrayList<String>());
            rsl.get(key).add(s);
        }
        return rsl;
    }
}
