package api;

import api.pojos.createuser.CreateUserRqPojo;
import api.pojos.createuser.CreateUserRsPojo;
import api.utilities.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static api.steps.UsersSteps.createNewUser;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Reqres")
public class CreateUserTest {

  private String currentDate;

  @BeforeMethod
  private void before() {
    currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
  }

  @Test
  @Description("Создать пользователя, убедиться, что имя и наименование работы в ответе соответствуют имени и " +
      "наименованию работы в запросе. Сравнить дату создания пользователя с текущей датой на машине")
  @Story("Post")
  @Owner("Victor SK")
  public void checkCreateUser() {
    CreateUserRqPojo rq = UserGenerator.getVictorUser();
    CreateUserRsPojo rs = createNewUser(rq);
    assertThat(rs)
        .isNotNull()
        .extracting(CreateUserRsPojo::getName)
        .isEqualTo(rq.getName());
    assertThat(rs)
        .isNotNull()
        .extracting(CreateUserRsPojo::getJob)
        .isEqualTo(rq.getJob());
    assertThat(currentDate).isEqualTo(rs.getCreatedAt().replaceAll(".{14}$", ""));
  }
}