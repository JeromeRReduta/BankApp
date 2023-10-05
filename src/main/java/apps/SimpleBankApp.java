package apps;

import configs.SimpleBankConfig;

/**
 * Simple implementation of a bank app
 */
public class SimpleBankApp implements App<SimpleBankConfig> {

    @Override
    public void run(SimpleBankConfig config) {
        config.context.run();
    }
}
