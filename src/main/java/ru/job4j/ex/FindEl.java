package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Искомый элемент " + key + " не найден");
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3"};
        try {
            int result = indexOf(value, "11");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
