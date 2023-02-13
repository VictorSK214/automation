package core.utils;

import core.config.LoginProvider;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;

public class Start implements LoginProvider {

  private static final String headerProducts = "Products";

  @Step("Открыть страницу авторизации, авторизоваться и проверить наименование заголовка")
  public static MainPage openAndLogin(String login) {
    return new LoginPage()
        .goToLoginPage()
        .fillUserName(login)
        .fillPassword(PASSWORD)
        .clickLoginButton()
        .checkHeaderProducts(headerProducts);
  }
}