package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.helpers.BrowserHelper;
import core.utils.UrlUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage implements BrowserHelper<LoginPage> {

  @Step("Открыть страницу авторизации")
  public LoginPage goToLoginPage() {
    open(UrlUtil.getBaseUrl());
    return page(LoginPage.class);
  }

  @FindBy(css = "#user-name")
  private SelenideElement userNameTextInput;

  @FindBy(css = "#password")
  private SelenideElement passwordTextInput;

  @FindBy(css = "#login-button")
  private SelenideElement loginButton;

  @FindBy(xpath = "//h3[@data-test='error']")
  private SelenideElement errorTextField;

  @Step("Проверить наличие placeholder в поле 'Username'")
  public LoginPage checkPlaceholderUserName(String userNamePrompt) {
    Assert.assertTrue(userNameTextInput.isDisplayed());
    String placeholder = userNameTextInput.getAttribute("placeholder");
    Assert.assertEquals(placeholder, userNamePrompt);
    return this;
  }

  @Step("Проверить наличие placeholder в поле 'Password'")
  public LoginPage checkPlaceholderPassword(String passwordPrompt) {
    Assert.assertTrue(passwordTextInput.isDisplayed());
    String placeholder = passwordTextInput.getAttribute("placeholder");
    Assert.assertEquals(placeholder, passwordPrompt);
    return this;
  }

  @Step("Заполнить поле 'Username'")
  public LoginPage fillUserName(String userName) {
    userNameTextInput
        .shouldBe(visible)
        .sendKeys(userName);
    return this;
  }

  @Step("Заполнить поле 'Password'")
  public LoginPage fillPassword(String pass) {
    passwordTextInput
        .shouldBe(visible)
        .sendKeys(pass);
    return this;
  }

  @Step("Клик по кнопке 'LOGIN'")
  public MainPage clickLoginButton() {
    loginButton
        .shouldBe(enabled)
        .click();
    return page(MainPage.class);
  }

  @Step("Проверить, что после заполнения поля 'Username', данное поле не пустое и присутствует введенный текст")
  public LoginPage checkForTextInFieldUserName(String userName) {
    userNameTextInput
        .shouldBe(visible)
        .shouldNotBe(empty)
        .shouldHave(value(userName));
    return this;
  }

  @Step("Проверить наличие текста в кнопке 'LOGIN'")
  public LoginPage checkForTextInLoginButton(String loginText) {
    loginButton.shouldHave(exactValue(loginText));
    return this;
  }

  @Step("Проверить цвет кнопки 'LOGIN'")
  public LoginPage checkColorInLoginButton() {
    String color = loginButton.getCssValue("background-color");
    String actualColor = Color.fromString(color).asHex();
    String expectedColor = "#e2231a";
    Assert.assertEquals(actualColor, expectedColor);
    return this;
  }

  @Step("Ввести в поле 'Username' некорректное значение")
  public LoginPage enterInvalidUserName(String invalidUserName) {
    userNameTextInput
        .shouldBe(visible)
        .sendKeys(invalidUserName);
    return this;
  }

  @Step("Ввести в поле 'Password' некорректный пароль")
  public LoginPage enterInvalidPass(String invalidPass) {
    passwordTextInput
        .shouldBe(visible)
        .sendKeys(invalidPass, Keys.ENTER);
    return this;
  }

  @Step("Проверить наличие ошибки после ввода некорректных значений логина и пароля")
  public LoginPage checkForError(String errorMessage) {
    errorTextField
        .shouldBe(visible)
        .shouldHave(Condition.text(errorMessage));
    return this;
  }
}