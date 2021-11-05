package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education,
                    String birthday, boolean inventor, String language) {
        super(name, surname, education, birthday, inventor);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
