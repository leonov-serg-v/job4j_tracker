package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> rsl = new HashMap<>();
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char ch =  s.charAt(i);
            rsl.putIfAbsent(ch, new ArrayList<>());
            rsl.get(ch).add(i);
        }
        return rsl;
    }
}
