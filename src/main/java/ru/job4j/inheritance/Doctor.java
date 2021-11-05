package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean childlike;

    public Doctor(String name, String surname, String education,
                  String birthday, boolean childlike) {
        super(name, surname, education, birthday);
        this.childlike = childlike;
    }

    public boolean isChildlike() {
        return childlike;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
