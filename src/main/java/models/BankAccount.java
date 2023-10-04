package models;

/**
 * Represents a bank account
 */
public interface BankAccount {

    void deposit(Number amount);

    void withdraw(Number amount);

    String getName();

    String getID();

    Number getMoney();
}
