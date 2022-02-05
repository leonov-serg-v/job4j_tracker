package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы
 * Содержит информацию о Клиентах банка и связанных с ними счетами
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 */
public class BankService {
    /**
     * Содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход Клиента банка
     * Если Клиент не найден в системе Банка, то выполняется его добавление с пустым списком счетов
     *
     * @param user Клиент банка которые добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счета к Клиенту банка
     * Поиск Клиента выполняется по номеру паспорта
     * Если Клиент найден и такого счета у Клиента нет, то выполняется добавление счета к Клиенту
     *
     * @param passport номер паспорта Клиента
     * @param account  счет для добавления к Клиенту
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет Клиента по номеру паспорта
     *
     * @param passport номер паспорта Клиента
     * @return Если Клиент не найден, то вернуть null, иначе найденный Клиент
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет Клиента по реквизитам
     *
     * @param passport  номер паспорта Клиента
     * @param requisite реквизиты счета
     * @return если Клиент найден и у Клиента есть счет с указанными реквизитами,
     * то вернуть "счет", иначе null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param srcPassport   номер паспорта Клиента со счета которого выполняется перевод
     * @param srcRequisite  реквизиты счета с которого выполняется перевод
     * @param destPassport  номер паспорта Клиента на счет которог выполняется зачисление
     * @param destRequisite реквизиты счета на который выполняется зачисление
     * @param amount        сумма операции
     * @return Если счёт(srcAccount/destAccount) не найден или
     * не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false, иначе true
     */
    @SuppressWarnings("checkstyle:LineLength")
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty()
                || srcAccount.get().getBalance() < amount
                || destAccount.isEmpty()) {
            return false;
        }
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}
