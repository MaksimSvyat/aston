import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("app.conf");
    }

    String URL = readConfig().getString("url");
    String BLOCK_NAME = readConfig().getString("blockName");
    String REF_URL = readConfig().getString("refUrl");
    String TEST_PHONE_NUMBER = readConfig().getString("testPhoneNumber");
    String TEST_SUM = readConfig().getString("testSum");
    String PHONE_IN_FORM = readConfig().getString("phoneInForm");
    String SUM_IN_FORM = readConfig().getString("sumInForm");
    String LOGO_1 = readConfig().getString("logo1");
    String LOGO_2 = readConfig().getString("logo2");
    String LOGO_3 = readConfig().getString("logo3");
    String LOGO_4 = readConfig().getString("logo4");
    String LOGO_5 = readConfig().getString("logo5");
}
