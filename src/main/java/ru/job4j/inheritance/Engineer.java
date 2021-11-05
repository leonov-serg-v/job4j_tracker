package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean inventor;

    public Engineer(String name, String surname, String education,
                    String birthday, boolean inventor) {
        super(name, surname, education, birthday);
        this.inventor = inventor;
    }

    public boolean isInventor() {
        return inventor;
    }

    public Subject make(Tool tool) {
        return new Subject();
    }
}
