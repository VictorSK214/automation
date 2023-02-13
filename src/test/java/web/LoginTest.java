package web;

import base.BaseTest;
import core.config.LoginProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("Swag Labs")
public class LoginTest extends BaseTest implements LoginProvider {

  private String userNamePrompt;
  private String passwordPrompt;
  private String invalidUserName;
  private String invalidPass;
  private String errorMessage;
  private String loginText;
  private String headerProducts;

  @BeforeMethod
  private void before() {
    userNamePrompt = "Username";
    passwordPrompt = "Password";
    invalidUserName = RandomStringUtils.randomAlphabetic(12);
    invalidPass = RandomStringUtils.randomNumeric(12);
    errorMessage = "Epic sadface: Username and password do not match any user in this service";
    loginText = "Login";
    headerProducts = "Products";
  }

  @Test
  @Description("Проверить, что в полях 'Username', 'Password' присутствует placeholder. Ввести в поля 'Username' и " +
      "'Password' некорректные данные, проверить наличие ошибки после вводе некорректных данных. " +
      "Ввести валидные данные в поля 'Username' и 'Password', проверить, что поле 'Username' не пустое " +
      "и заполнено, на кнопке 'LOGIN' присутствует текст, фоновый цвет - красный. После авторизации проверить " +
      "url и отображение заголовка на основной странице")
  @Story("Login test")
  @Owner("Victor SK")
  public void checkLoginSwag() {
    new LoginPage()
        .goToLoginPage()
        .checkPlaceholderUserName(userNamePrompt)
        .checkPlaceholderPassword(passwordPrompt)
        .enterInvalidUserName(invalidUserName)
        .enterInvalidPass(invalidPass)
        .checkForError(errorMessage)
        .refreshPage()
        .waitFor(1000L)
        .fillUserName(STANDARD_USER)
        .checkForTextInFieldUserName(STANDARD_USER)
        .fillPassword(PASSWORD)
        .checkForTextInLoginButton(loginText)
        .checkColorInLoginButton()
        .clickLoginButton()
        .checkCurrentUrl()
        .checkHeaderProducts(headerProducts);
  }
}