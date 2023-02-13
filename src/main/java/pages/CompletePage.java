package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class CompletePage {

  @FindBy(css = ".complete-header")
  private SelenideElement completeHeader;

  @Step("Проверить наименование заголовка после приобретения товара")
  public CompletePage checkCompleteHeader(String complete) {
    completeHeader
        .shouldBe(Condition.visible)
        .shouldHave(Condition.text(complete));
    return this;
  }
}