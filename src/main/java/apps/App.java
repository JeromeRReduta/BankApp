package apps;

import configs.Config;

/**
 * Represents app logic
 * @param <C> Config type, which allows enforcing matching configs at compile-time
 */
public interface App<C extends Config> {

    /**
     * Given a specific config, runs the app
     * @param config config
     */
    void run(C config);
}
