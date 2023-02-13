package api;

import api.pojos.registration.RegRqPojo;
import api.pojos.registration.SuccessRegRsPojo;
import api.pojos.registration.UnSuccessRegRsPojo;
import api.steps.UsersSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Reqres")
public class RegistrationUserTest {

  private String eveEmail;
  private String password;
  private Integer id;
  private String token;
  private String sydneyEmail;
  private String error;

  @BeforeMethod
  private void before() {
    eveEmail = "eve.holt@reqres.in";
    password = "cityslicka";
    id = 4;
    token = "QpwL5tke4Pnpja7X4";
    sydneyEmail = "sydney@fife";
    error = "Missing password";
  }

  @Test
  @Description("Проверка успешной регистрации пользователя в системе")
  @Story("Post")
  @Owner("Victor SK")
  public void checkSuccessRegUser() {
    RegRqPojo rq = new RegRqPojo(eveEmail, password);
    SuccessRegRsPojo rs = UsersSteps.successUserReg(rq);
    assertThat(rs)
        .isNotNull()
        .extracting(SuccessRegRsPojo::getId)
        .isEqualTo(id);
    assertThat(rs)
        .isNotNull()
        .extracting(SuccessRegRsPojo::getToken)
        .isEqualTo(token);
  }

  @Test
  @Description("Проверка регистрации пользователя с ошибкой ввиду отсутствия пароля")
  @Story("Post")
  @Owner("Victor SK")
  public void checkUnSuccessRegUser() {
    RegRqPojo rq = new RegRqPojo(sydneyEmail, "");
    UnSuccessRegRsPojo rs = UsersSteps.unSuccessUserReg(rq);
    assertThat(rs)
        .isNotNull()
        .extracting(UnSuccessRegRsPojo::getError)
        .isEqualTo(error);
  }
}