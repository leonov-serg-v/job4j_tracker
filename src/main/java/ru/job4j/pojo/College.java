package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Леонов С В");
        student.setGroup("2204");
        student.setDateOfReceipt("01/09/1991");
        String ln = System.lineSeparator();
        System.out.println("ФИО : " + student.getFio() + ln
                         + "Группа : " + student.getGroup() + ln
                         + "Дата поступления : " + student.getDateOfReceipt());
    }
}
