package apps;

import configs.Config;

public interface App<C extends Config> {

    /**
     * Given a specific config, runs the app
     * @param config config
     */
    void run(C config);
}
