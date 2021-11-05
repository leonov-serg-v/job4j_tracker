package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String typeOfConstruction;

    public Builder(String name, String surname, String education,
                      String birthday, boolean inventor, String typeOfConstruction) {
        super(name, surname, education, birthday, inventor);
        this.typeOfConstruction = typeOfConstruction;
    }
}
