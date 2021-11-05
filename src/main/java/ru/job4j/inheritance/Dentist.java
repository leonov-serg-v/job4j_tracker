package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean prosthetist;

    public Dentist(String name, String surname, String education,
                   String birthday, boolean childlike, boolean prosthetist) {
        super(name, surname, education, birthday, childlike);
        this.prosthetist = prosthetist;
    }

    public boolean isProsthetist() {
        return prosthetist;
    }
}
