package web;

import base.BaseTest;
import core.config.ConfigProvider;
import core.config.LoginProvider;
import core.utils.Start;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Swag Labs")
public class BuyProductTest extends BaseTest implements LoginProvider {

  private static ConfigProvider config;
  private String product;
  private String description;
  private double price;
  private double tax;
  private String complete;

  @BeforeMethod
  private void before() {
    config = ConfigProvider.getInstance();
    product = "Sauce Labs Bolt T-Shirt";
    description = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, " +
        "100% ringspun combed cotton, heather gray with red bolt.";
    price = 15.99;
    tax = 1.28;
    complete = "THANK YOU FOR YOUR ORDER";
  }

  @Test
  @Description("Купить 'Sauce Labs Bolt T-Shirt'. Убедиться, что наименование, описание и цена товара соответствует " +
      "данным значениям на странице непосредственно перед приобретением товара. Проверить значение налога. " +
      "Убедиться, что после клика по кнопке 'ADD TO CART' цвет кнопки изменился")
  @Owner("Victor SK")
  public void buyProduct() {
    Start
        .openAndLogin(STANDARD_USER)
        .selectItem(product)
        .checkItemName(product)
        .checkItemDescription(description)
        .checkItemPrice(price)
        .checkColorButton()
        .clickAddToCard()
        .checkColorButtonAfterClick()
        .clickShoppingCart()
        .clickCheckout()
        .fillFirstName(config.userData().getFirstName())
        .fillLastName(config.userData().getLastName())
        .fillZipCode(config.userData().getZipCode())
        .clickContinue()
        .checkItemNameBeforePay(product)
        .checkItemDescriptionBeforePay(description)
        .checkItemPriceBeforePay(price)
        .checkTax(tax)
        .clickFinish()
        .checkCompleteHeader(complete);
  }
}