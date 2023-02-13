package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class CheckoutPage {

  @FindBy(css = "#first-name")
  private SelenideElement firstNameTextInput;

  @FindBy(css = "#last-name")
  private SelenideElement lastNameTextInput;

  @FindBy(css = "#postal-code")
  private SelenideElement zipCodeTextInput;

  @FindBy(css = "#continue")
  private SelenideElement continueButton;

  @Step("Заполнить поле 'First Name'")
  public CheckoutPage fillFirstName(String firstName) {
    firstNameTextInput
        .shouldBe(Condition.visible)
        .sendKeys(firstName);
    return this;
  }

  @Step("Заполнить поле 'Last Name'")
  public CheckoutPage fillLastName(String lastName) {
    lastNameTextInput
        .shouldBe(Condition.visible)
        .sendKeys(lastName);
    return this;
  }

  @Step("Заполнить поле 'Zip/Postal Code'")
  public CheckoutPage fillZipCode(String zipCode) {
    zipCodeTextInput
        .shouldBe(Condition.visible)
        .sendKeys(zipCode);
    return this;
  }

  @Step("Клик по кнопке 'CONTINUE'")
  public OverviewPage clickContinue() {
    continueButton
        .shouldBe(Condition.enabled)
        .click();
    return page(OverviewPage.class);
  }
}