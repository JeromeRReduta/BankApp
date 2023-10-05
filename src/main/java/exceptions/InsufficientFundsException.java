package exceptions;

/**
 * An exception thrown when someone attempts to withdraw too much money
 * from their account
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
