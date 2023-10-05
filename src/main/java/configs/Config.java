package configs;

/**
 * Configurations for the app
 */
public interface Config {

    /**
     * Factory pattern
     * @param <C> Config type
     */
    static interface Factory<C extends Config> {

        /**
         * Creates the config.
         * @implNote This should be the only way to create a new config
         * @return new config
         */
        C create();

    }
}
