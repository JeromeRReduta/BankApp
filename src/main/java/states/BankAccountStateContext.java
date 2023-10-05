package states;

import models.BankAccount;

/**
 * Implementation of a state context with model for a bank account
 */
public class BankAccountStateContext implements StateContextWithModel<BankAccount> {

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
