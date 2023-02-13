package core.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;

public class DriverConfig {
  public static void getWebDriver() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    Configuration.fileDownload = FOLDER;
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }
}