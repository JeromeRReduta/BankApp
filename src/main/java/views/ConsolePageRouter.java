package views;

import models.BankAccount;
import models.SimpleBankAccount;
import views.pages.AbstractPageRouter;
import views.pages.ConsolePages;
import views.pages.Page;

public class ConsolePageRouter
        extends AbstractPageRouter<BankAccount>
        implements BankAccountView {

    private final Page<BankAccount> login;

    private final Page<BankAccount> menu;

    private final Page<BankAccount> deposit;

    private final Page<BankAccount> withdraw;

    private final Page<BankAccount> display;

    private final Page<BankAccount> exit;


    public ConsolePageRouter(BankAccount account,
                             Page<BankAccount> login,
                             Page<BankAccount> menu,
                             Page<BankAccount> deposit,
                             Page<BankAccount> withdraw,
                             Page<BankAccount> display,
                             Page<BankAccount> exit) {
        super(account);
        this.login = login;
        this.menu = menu;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.display = display;
        this.exit = exit;
    }

    @Override
    public void displayLoginPage() {
        super.loadPage(login);
    }

    @Override
    public void displayMenuPage() {
        super.loadPage(menu);
    }

    @Override
    public void displayDepositPage() {
        super.loadPage(deposit);
    }

    @Override
    public void displayWithdrawPage() {
        super.loadPage(withdraw);
    }

    @Override
    public void displayDisplayPage() {
        super.loadPage(display);
    }

    @Override
    public void displayExitPage() {
        super.loadPage(exit);
    }
}
