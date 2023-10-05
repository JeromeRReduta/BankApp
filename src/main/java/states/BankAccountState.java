package states;

import exceptions.InsufficientFundsException;
import models.BankAccount;
import utility.InputValidator;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Implementation of a StateWithModel for BankAccounts.
 */
public interface BankAccountState extends StateWithModel<BankAccount> {
    Scanner scan = new Scanner(System.in);

    static BankAccountState LOGIN = context -> {
        String content =
                """
                BANKINGTON BANKS
                Please enter your username and password.
                """;
        System.out.println(content);
        System.out.println("Username:");
        String userName = scan.nextLine();
        System.out.println("Password:");
        scan.nextLine(); // We don't actually use the password in this implementation
        context.getModel().setName(userName);
        context.setState(BankAccountState.MENU);
    };

    Predicate<String> isOneThroughFour = input -> {
        String trimmedInput = input.trim();
        return trimmedInput.equals("1")
                || trimmedInput.equals("2")
                || trimmedInput.equals("3")
                || trimmedInput.equals("4");
    };
    static BankAccountState MENU = context -> {
        BankAccount account = context.getModel();
        System.out.printf(
                """
                You currently have $%.2f.
                """,
                account.getMoney().doubleValue());

        InputValidator optionValidator = new InputValidator(
                scan,
                """
         
                Please select a number:
                [1] Deposit funds
                [2] Withdraw
                [3] Display bank details
                [4] Exit
                """,
                BankAccountState.isOneThroughFour);
        String option = optionValidator.getValidInput();
        switch (option) {
            case "1" -> context.setState(BankAccountState.DEPOSIT);
            case "2" -> context.setState(BankAccountState.WITHDRAW);
            case "3" -> context.setState(BankAccountState.DISPLAY);
            default -> context.setState(BankAccountState.LOGOUT);
        }
    };

    Predicate<String> canBeADouble = input -> {
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    };

    BankAccountState DEPOSIT = context -> {
        BankAccount account = context.getModel();
        String message = String.format(
                """
				You currently have $%.2f.
				Please enter your deposit amount.
				Enter 0 to go back to menu.
				""",
                account.getMoney().doubleValue());
        InputValidator numberValidator = new InputValidator(
                scan,
                message,
                canBeADouble);
        double validInput = Double.parseDouble(numberValidator.getValidInput());
        account.deposit(validInput);
        context.setState(BankAccountState.MENU);
    };

    BankAccountState WITHDRAW = context -> {
        BankAccount account = context.getModel();
        String message = String.format(
                """
                You currently have $%.2f.
                You can borrow money up to a debt limit.
                Please enter your withdrawal amount.
                Or enter 0 to go back to the menu.
                """,
                account.getMoney().doubleValue());

        InputValidator numberValidator = new InputValidator(
                scan,
                message,
                canBeADouble);
        double validInput = Double.parseDouble(numberValidator.getValidInput());
        try {
            account.withdraw(validInput);
            context.setState(BankAccountState.MENU);
        }
        catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
            context.setState(BankAccountState.WITHDRAW);
        }
    };

    BankAccountState DISPLAY = context -> {
        BankAccount model = context.getModel();
        System.out.printf(
        """
        BANKINGTON BANKS ACCOUNT #%d
        [%s]
        $%.2f
        Enter any input to go back to menu.
        """,
        model.getID().intValue(),
        model.getName(),
        model.getMoney().doubleValue());
        scan.nextLine();
        context.setState(BankAccountState.MENU);
    };

    BankAccountState LOGOUT = context -> {
        System.out.printf(
                """
                You are now leaving Bankington Banks.
                Goodbye %s!
                """,
                context.getModel().getName()
        );
        context.setState(BankAccountState.SHUTDOWN);
    };

    BankAccountState SHUTDOWN = StateContextWithModel::close;
}
