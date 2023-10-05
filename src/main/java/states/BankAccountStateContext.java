package states;

import models.BankAccount;
import models.SimpleBankAccount;

public class BankAccountStateContext implements StateContextWithModel<BankAccount> {

    public static void main(String[] args) {
        BankAccountStateContext context = new BankAccountStateContext(
                BankAccountState.LOGIN,
                new SimpleBankAccount(
                        "Placeholder",
                        5,
                        0));
        context.run();
    }

    private final BankAccount account;

    private StateWithModel<BankAccount> state;

    private boolean isFinished;

    public BankAccountStateContext(
            StateWithModel<BankAccount> initialState,
            BankAccount account) {
        this.account = account;
        this.state = initialState;
        this.isFinished = false;
    }

    @Override
    public void run() {
        while (!isFinished) {
            state.handle(this);
        }
    }

    @Override
    public void close() {
        isFinished = true;
    }

    @Override
    public StateWithModel<BankAccount> getState() {
        return state;
    }

    @Override
    public void setState(StateWithModel<BankAccount> state) {
        this.state = state;
    }

    @Override
    public BankAccount getModel() {
        return account;
    }
}
