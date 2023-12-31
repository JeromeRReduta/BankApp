package models;

import exceptions.InsufficientFundsException;

/**
 * Simple implementation of a BankAccount
 */
public class SimpleBankAccount implements BankAccount {

    private final static double MAX_DEBT_ALLOWED = -100.00;

    private String name;

    private final int id;

    private double money;

    public SimpleBankAccount(String name, int id, double money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    @Override
    public void deposit(Number amount) {
        this.money += amount.doubleValue();
    }

    @Override
    public void withdraw(Number amount) throws InsufficientFundsException {
        double moneyAfterTransaction = money - amount.doubleValue();
        if (moneyAfterTransaction < MAX_DEBT_ALLOWED) {
            throw new InsufficientFundsException("Transaction cancelled - not enough funds");
        }
        this.money = moneyAfterTransaction;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Number getID() {
        return id;
    }

    @Override
    public Number getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format(
                """
                %s [%d]:
                $%.2f
                """,
                name,
                id,
                money);
    }
}
