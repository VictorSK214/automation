package api;

import api.steps.UsersSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Reqres")
public class DeleteUserTest {

  private final UsersSteps usersSteps = new UsersSteps();

  @Test
  @Description("Проверка удаления пользователя из системы")
  @Story("Delete")
  @Owner("Victor SK")
  public void checkDeleteUser() {
    usersSteps.deleteUser();
  }
}