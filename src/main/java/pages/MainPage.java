package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

  @FindBy(xpath = "//div[@class='header_secondary_container']/span")
  private SelenideElement productsHeader;

  @FindBy(css = ".product_sort_container")
  private SelenideElement productSortContainerDropDown;

  @FindBy(css = ".product_sort_container option")
  private ElementsCollection productSortContainerTextField;

  @FindBy(css = ".inventory_item_price")
  private ElementsCollection currencyTextField;

  @FindBy(css = ".inventory_item_name")
  private ElementsCollection itemNameTextFiled;

  @Step("Проверить url на основной странице")
  public MainPage checkCurrentUrl() {
    webdriver().shouldHave(url("https://www.saucedemo.com/inventory.html"));
    return this;
  }

  @Step("Проверить наименование заголовка на основной странице")
  public MainPage checkHeaderProducts(String headerProducts) {
    productsHeader
        .shouldBe(Condition.visible)
        .shouldHave(text(headerProducts));
    return this;
  }

  @Step("Проверить наименования представленных товаров")
  public MainPage checkNumberOfProductsAvailable(List<String> numberOfProductsAvailable) {
    itemNameTextFiled.shouldHave(CollectionCondition.texts(numberOfProductsAvailable));
    return this;
  }

  @Step("Убедиться, что у каждого товара перед ценой присутствует знак валюты")
  public MainPage checkCurrency(String currency) {
    currencyTextField
        .shouldBe(CollectionCondition
            .allMatch("each product has a currency sign in front of the price",
                elements -> elements.getText().startsWith(currency)));
    return this;
  }

  @Step("Клик на контейнер сортировки")
  public MainPage clickProductSortContainer() {
    productSortContainerDropDown
        .shouldBe(Condition.visible)
        .click();
    return this;
  }

  @Step("Проверить все имеющиеся варианты сортировок в контейнере")
  public MainPage checkProductSortContainer(List<String> productSort) {
    productSortContainerTextField.shouldHave(CollectionCondition.texts(productSort));
    return this;
  }

  @Step("Выбрать товар")
  public DetailedDescriptionPage selectItem(String item) {
    itemNameTextFiled
        .findBy(Condition.exactText(item))
        .shouldBe(Condition.visible)
        .click();
    return page(DetailedDescriptionPage.class);
  }
}