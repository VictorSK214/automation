package web;

import base.BaseTest;
import core.config.LoginProvider;
import core.data.CurrencySymbol;
import core.utils.Start;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Epic("Swag Labs")
public class ItemsTest extends BaseTest implements LoginProvider {

  private List<String> numberOfProductsAvailable;
  private List<String> productSort;

  @BeforeMethod
  private void before() {
    numberOfProductsAvailable =
        Stream.of("Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)")
            .collect(Collectors.toList());
    productSort =
        Stream.of(
                "Name (A to Z)",
                "Name (Z to A)",
                "Price (low to high)",
                "Price (high to low)")
            .collect(Collectors.toList());
  }

  @Test
  @Description("Проверить наименования представленных товаров, доступных сортировок в контейнере, " +
      "убедиться, что у каждого товара перед ценой присутствует знак валюты")
  @Owner("Victor SK")
  public void checkItems() {
    Start
        .openAndLogin(STANDARD_USER)
        .checkNumberOfProductsAvailable(numberOfProductsAvailable)
        .checkCurrency(CurrencySymbol.USD.getCurrency())
        .clickProductSortContainer()
        .checkProductSortContainer(productSort);
  }
}