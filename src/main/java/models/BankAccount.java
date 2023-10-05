package models;
import exceptions.InsufficientFundsException;

/**
 * Represents a bank account
 */
public interface BankAccount {

    /**
     * Deposits money into the account
     * @param amount amount of money
     */
    void deposit(Number amount);

    /**
     * Withdraws money from the account
     * @param amount amount of money
     * @throws InsufficientFundsException if the user attempts to withdraw "too much"
     * money. How much is "too much" is defined by the implementation.
     */
    void withdraw(Number amount) throws InsufficientFundsException;

    /**
     * Returns the name of the account owner
     * @return account owner's name
     */
    String getName();

    /**
     * Sets the account owner's name
     * @param name new name
     */
    void setName(String name);

    /**
     * Gets the account's id
     * @return account id
     */
    Number getID();

    /**
     * Returns how much money this account has
     * @return how much money this account has
     */
    Number getMoney();
}
