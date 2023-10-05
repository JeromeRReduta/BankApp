package configs;

import models.BankAccount;
import models.SimpleBankAccount;
import states.BankAccountState;
import states.BankAccountStateContext;
import states.StateContextWithModel;
import states.StateWithModel;

import java.util.Random;

/**
 * Simple implementation of a config for the bank app
 */
public class SimpleBankConfig implements Config {

    public final StateContextWithModel<BankAccount> context;

    private SimpleBankConfig(StateContextWithModel<BankAccount> context) {
        this.context = context;
    }

    /**
     * Factory pattern for this config
     */
    public static class Factory implements Config.Factory<SimpleBankConfig> {

        private final Random random = new Random();

        private final int idCeiling = 5000;

        private final double startingMoneyCeiling = 10000000;

        private final String placeholderName = "PLACEHOLDER";

        public Factory() {
        }

        @Override
        public SimpleBankConfig create() {
            int id = random.nextInt(idCeiling);
            double startingMoney = random.nextDouble(startingMoneyCeiling);
            BankAccount account = new SimpleBankAccount(
                    placeholderName,
                    id,
                    startingMoney);
            StateWithModel<BankAccount> initialState = BankAccountState.LOGIN;
            StateContextWithModel<BankAccount> context = new BankAccountStateContext(
                    initialState,
                    account);
            return new SimpleBankConfig(context);
        }
    }
}
