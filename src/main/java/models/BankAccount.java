package models;
import exceptions.InsufficientFundsException;

/**
 * Represents a bank account
 */
public interface BankAccount {

    void deposit(Number amount);

    void withdraw(Number amount) throws InsufficientFundsException;

    String getName();

    Number getID();

    Number getMoney();
}
