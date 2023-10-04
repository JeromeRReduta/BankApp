package configs;

public interface Config {

    static interface Factory<C extends Config> {

        C create();

    }
}
