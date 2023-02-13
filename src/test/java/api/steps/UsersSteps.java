package api.steps;

import api.pojos.createuser.CreateUserRqPojo;
import api.pojos.createuser.CreateUserRsPojo;
import api.pojos.registration.RegRqPojo;
import api.pojos.registration.SuccessRegRsPojo;
import api.pojos.registration.UnSuccessRegRsPojo;
import api.pojos.updateuserdata.UpdateUserDataRqPojo;
import api.pojos.updateuserdata.UpdateUserDataRsPojo;
import api.pojos.users.UsersDataRsPojo;
import api.utilities.EndPoints;
import io.qameta.allure.Step;
import java.util.List;
import static api.utilities.Spec.RQ_SPEC;
import static io.restassured.RestAssured.given;

public class UsersSteps {

  @Step("Получить список пользователей со второй страницы")
  public static List<UsersDataRsPojo> getListOfUsers() {
    return given()
        .spec(RQ_SPEC)
        .get(EndPoints.usersPageTwo)
        .then().statusCode(200)
        .extract().jsonPath().getList("data", UsersDataRsPojo.class);
  }

  @Step("Создание нового пользователя {rq.name}")
  public static CreateUserRsPojo createNewUser(CreateUserRqPojo rq) {
    return given()
        .spec(RQ_SPEC)
        .body(rq)
        .post(EndPoints.users)
        .then().statusCode(201)
        .extract().as(CreateUserRsPojo.class);
  }

  @Step("Обновление данных о пользователе {rq.name}")
  public static UpdateUserDataRsPojo updateUserData(UpdateUserDataRqPojo rq) {
    return given()
        .spec(RQ_SPEC)
        .body(rq)
        .put(EndPoints.usersTwo)
        .then().statusCode(200)
        .extract().as(UpdateUserDataRsPojo.class);
  }

  @Step("Успешная регистрация пользователя в системе")
  public static SuccessRegRsPojo successUserReg(RegRqPojo rq) {
    return given()
        .spec(RQ_SPEC)
        .body(rq)
        .post(EndPoints.register)
        .then().statusCode(200)
        .extract().as(SuccessRegRsPojo.class);
  }

  @Step("Регистрация пользователя в системе с ошибкой")
  public static UnSuccessRegRsPojo unSuccessUserReg(RegRqPojo rq) {
    return given()
        .spec(RQ_SPEC)
        .body(rq)
        .post(EndPoints.register)
        .then().statusCode(400)
        .extract().as(UnSuccessRegRsPojo.class);
  }

  @Step("Удаление пользователя из системы")
  public UsersSteps deleteUser() {
    given()
        .spec(RQ_SPEC)
        .delete(EndPoints.usersTwo)
        .then().statusCode(204);
    return this;
  }
}