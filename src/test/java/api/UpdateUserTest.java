package api;

import api.pojos.updateuserdata.UpdateUserDataRqPojo;
import api.pojos.updateuserdata.UpdateUserDataRsPojo;
import api.utilities.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static api.steps.UsersSteps.updateUserData;

@Epic("Reqres")
public class UpdateUserTest {

  @Test
  @Description("Обновить данные о пользователе, убедиться, что имя и наименование работы в ответе соответствуют " +
      "имени и наименованию работы в запросе")
  @Story("Put")
  @Owner("Victor SK")
  public void checkUserDataUpdate() {
    UpdateUserDataRqPojo rq = UserGenerator.getShelbyUser();
    UpdateUserDataRsPojo rs = updateUserData(rq);
    assertThat(rs)
        .isNotNull()
        .extracting(UpdateUserDataRsPojo::getName)
        .isEqualTo(rq.getName());
    assertThat(rs)
        .isNotNull()
        .extracting(UpdateUserDataRsPojo::getJob)
        .isEqualTo(rq.getJob());
  }
}