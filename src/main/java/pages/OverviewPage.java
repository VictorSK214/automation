package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class OverviewPage {
  
  @FindBy(css = ".inventory_item_name")
  private SelenideElement detailsNameTextField;

  @FindBy(css = ".inventory_item_desc")
  private SelenideElement detailsDescTextField;

  @FindBy(css = ".inventory_item_price")
  private SelenideElement detailsPriceTextField;

  @FindBy(css = ".summary_tax_label")
  private SelenideElement taxTextField;

  @FindBy(css = "#finish")
  private SelenideElement finishButton;

  @Step("Проверить наименование товара перед покупкой")
  public OverviewPage checkItemNameBeforePay(String itemName) {
    detailsNameTextField
        .shouldBe(visible)
        .shouldHave(text(itemName));
    return this;
  }

  @Step("Проверить наименование товара перед покупкой")
  public OverviewPage checkItemDescriptionBeforePay(String itemDescription) {
    detailsDescTextField
        .shouldBe(visible)
        .shouldHave(text(itemDescription));
    return this;
  }

  @Step("Проверить цену товара перед покупкой")
  public OverviewPage checkItemPriceBeforePay(double expectedPrice) {
    double actualPrice =
        Double.parseDouble(detailsPriceTextField.shouldBe(visible).getText().replaceAll("^.", ""));
    Assert.assertEquals(actualPrice, expectedPrice);
    return this;
  }

  @Step("Проверить значение налога")
  public OverviewPage checkTax(double expectedTax) {
    double actualTax =
        Double.parseDouble(taxTextField.shouldBe(visible).getText().replaceAll("[^\\d.]", ""));
    Assert.assertEquals(actualTax, expectedTax);
    return this;
  }

  @Step("Клик по кнопке 'FINISH'")
  public CompletePage clickFinish() {
    finishButton
        .shouldBe(Condition.enabled)
        .click();
    return page(CompletePage.class);
  }
}