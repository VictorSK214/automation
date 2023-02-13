package core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import core.data.UserData;

public class ConfigProvider {
  private Config config;
  private UserData userData;

  private ConfigProvider() {
    config = ConfigFactory.systemProperties()
        .withFallback(ConfigFactory.parseResources("userdata.json"));
  }

  public UserData userData() {
    userData = ConfigBeanFactory.create(config.getConfig("userData"), UserData.class);
    return userData;
  }

  public static ConfigProvider getInstance() {
    return new ConfigProvider();
  }
}