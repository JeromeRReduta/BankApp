package models;
import exceptions.InsufficientFundsException;

/**
 * Represents a bank account
 */
public interface BankAccount {

    void deposit(Number amount);

    void withdraw(Number amount) throws InsufficientFundsException;

    String getName();

    void setName(String name);

    Number getID();

    Number getMoney();
}
