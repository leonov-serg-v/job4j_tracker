package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель Клиента банка
 */
public class User {
    /**
     * Номер документа-паспорт. Идентифицирует Клиента банка
     */
    private String passport;
    /**
     * ФИО Клиента банка
     */
    private String username;

    /**
     * Инциализация Клиента при создании
     * @param passport номер паспорта Клиента
     * @param username ФИО Клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получение значения поля "Номер паспорта"
     * @return возвращает текущее значение поля
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Установить новое значение поля "Номер паспорта"
     * @param passport новое значение поля
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получение значения поля "ФИО Клиента"
     * @return возращает текущее значение поля
     */
    public String getUsername() {
        return username;
    }

    /**
     * Установить новое значение поля "ФИО Клиента"
     * @param username новое значение поля
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнение двух объектов "Клиент банка"
     * Два объекта равны если у них равны значения поле "Номер паспорта"
     * @param o Клиент с которым выполняется сравнение
     * @return возвращает true клиенты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Вычисление hash кода объекта
     * Для вычисления используется значение поля "Номер паспорта"
     * @return возвращает значение hash кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
