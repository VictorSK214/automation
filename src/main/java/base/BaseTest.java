package base;

import com.codeborne.selenide.Selenide;
import core.config.DriverConfig;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

  @BeforeTest
  public void baseStartConfig() {
    DriverConfig.getWebDriver();
  }

  @AfterTest
  public void tearDown() {
    Selenide.closeWebDriver();
  }
}