package views.pages;

import models.BankAccount;

public class ConsolePages {

    public static final Page<BankAccount> login = account -> {
        String content =
                """
                BANKINGTON BANKS
                Please enter your username and password.
                """;
        System.out.println(content);
    };

    public static final Page<BankAccount> menu = account -> {
        String content = String.format(
                """
                You currently have $%.2f.
                Please select a number:
                [1] Deposit funds
                [2] Withdraw
                [3] Display bank details
                [4] Exit
                """,
                account.getMoney().doubleValue());
        System.out.println(content);
    };

    public static final Page<BankAccount> deposit = account -> {
        String content = String.format(
                """
                You currently have $%.2f.
                Please enter your deposit amount:
                """,
                account.getMoney().doubleValue());
        System.out.println(content);
    };

    public static final Page<BankAccount> withdraw = account -> {
        String content = String.format(
                """
                You currently have $%.2f.
                (You can borrow money, but there is a debt limit.)
                Please enter your withdrawal amount:
                """,
                account.getMoney().doubleValue());
        System.out.println(content);
    };

    public static Page<BankAccount> display = account -> {
        String content = String.format(
                """
                BANKINGTON BANKS ACCOUNT #%d
                [%s]
                $%.2f
                """,
                account.getID().intValue(),
                account.getName(),
                account.getMoney().doubleValue());
        System.out.println(content);
    };

    public static Page<BankAccount> exit = account -> {
        String content =
                """
                You are now leaving Bankington Banks.
                Goodbye!
                """;
        System.out.println(content);
    };
}
