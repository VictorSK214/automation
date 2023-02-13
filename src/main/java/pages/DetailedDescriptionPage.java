package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class DetailedDescriptionPage {

  @FindBy(css = ".inventory_details_name")
  private SelenideElement detailsNameTextField;

  @FindBy(css = ".inventory_details_desc")
  private SelenideElement detailsDescTextField;

  @FindBy(css = ".inventory_details_price")
  private SelenideElement detailsPriceTextField;

  @FindBy(css = ".btn_primary")
  private SelenideElement addToCardButton;

  @FindBy(xpath = "//button[text()='Remove']")
  private SelenideElement removeButton;

  @FindBy(css = ".shopping_cart_link")
  private SelenideElement shoppingCartLink;

  @Step("Проверить наименование товара")
  public DetailedDescriptionPage checkItemName(String itemName) {
    detailsNameTextField
        .shouldBe(visible)
        .shouldHave(text(itemName));
    return this;
  }

  @Step("Проверить описание товара")
  public DetailedDescriptionPage checkItemDescription(String itemDescription) {
    detailsDescTextField
        .shouldBe(visible)
        .shouldHave(text(itemDescription));
    return this;
  }

  @Step("Проверить цену товара")
  public DetailedDescriptionPage checkItemPrice(double expectedPrice) {
    double actualPrice =
        Double.parseDouble(detailsPriceTextField.shouldBe(visible).getText().replaceAll("^.", ""));
    Assert.assertEquals(actualPrice, expectedPrice);
    return this;
  }

  @Step("Проверить цвет кнопки 'ADD TO CARD'")
  public DetailedDescriptionPage checkColorButton() {
    String color = addToCardButton.getCssValue("color");
    String actualColor = Color.fromString(color).asHex();
    String expectedColor = "#e2231a";
    Assert.assertEquals(actualColor, expectedColor);
    return this;
  }

  @Step("Клик на кнопку 'ADD TO CARD'")
  public DetailedDescriptionPage clickAddToCard() {
    addToCardButton
        .shouldBe(Condition.enabled)
        .click();
    return this;
  }

  @Step("Проверить цвет кнопки 'ADD TO CARD' после клика по данной кнопке")
  public DetailedDescriptionPage checkColorButtonAfterClick() {
    String color = removeButton.getCssValue("color");
    String actualColor = Color.fromString(color).asHex();
    String expectedColor = "#474c55";
    Assert.assertEquals(actualColor, expectedColor);
    return this;
  }

  @Step("Клик по ссылке 'Корзина покупателя'")
  public ShoppingCartPage clickShoppingCart() {
    shoppingCartLink
        .shouldBe(Condition.enabled)
        .click();
    return page(ShoppingCartPage.class);
  }
}