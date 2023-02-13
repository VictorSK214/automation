package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class ShoppingCartPage {

  @FindBy(css = "#checkout")
  private SelenideElement checkoutButton;

  @Step("Клик по кнопке 'CHECKOUT'")
  public CheckoutPage clickCheckout() {
    checkoutButton
        .shouldBe(Condition.enabled)
        .click();
    return page(CheckoutPage.class);
  }
}