package apps;

import configs.SimpleBankConfig;

public class SimpleBankApp implements App<SimpleBankConfig> {

    @Override
    public void run(SimpleBankConfig config) {
        config.context.run();
    }
}
