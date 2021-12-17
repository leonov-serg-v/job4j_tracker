package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Leonov Serg
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета, идентифицируют счет.
     * Если у счета одинаковые реквизиты, то это один и тот же счет
     */
    private String requisite;
    /**
     * Остаток на счете
     */
    private double balance;

    /**
     * Инциализация счета при создании
     * @param requisite реквизиты/идентификатор счета
     * @param balance остаток на счете
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получение значения поля "Реквизит"
     * @return возвращает значение поля "Реквизит"
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Установка значения поля "Реквизит"
     * @param requisite новое значение поля "Реквизит"
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получение значения поля "Баланс"
     * @return возвращает значение поля "Баланс"
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Установка значения поля "Баланс"
     * @param balance новое значение поля "Баланс"
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Проверка равенства объектов "Банковский счет"
     * Два объекта равны если у них равны значения полей "реквизиты"
     * @param o счет с которым выполняется сравнение
     * @return возвращает true счета равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Вычисление hash кода объекта
     * Для вычисления используется значение поля "Реквизит"
     * @return возвращает значение hash кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
