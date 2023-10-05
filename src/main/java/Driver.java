import apps.App;
import apps.SimpleBankApp;
import configs.SimpleBankConfig;

public class Driver {

    public static void main(String[] args) {
        SimpleBankConfig config = new SimpleBankConfig.Factory().create();
        App<SimpleBankConfig> app = new SimpleBankApp();
        app.run(config);
    }
}
