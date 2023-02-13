package api;

import api.pojos.users.UsersDataRsPojo;
import api.steps.UsersSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Reqres")
public class ListOfUsersTest {

  @Test
  @Description("Убедиться, что список пользователей не является пустым и содержит 6 пользователей")
  @Story("Get")
  @Owner("Victor SK")
  public void checkListOfUsers() {
    assertThat(UsersSteps.getListOfUsers()).isNotNull().hasSize(6);
  }

  @Test
  @Description("Убедиться, что email пользователей имеет окончание '@reqres.in'")
  @Story("Get")
  @Owner("Victor SK")
  public void checkEndingEmails() {
    assertThat(UsersSteps.getListOfUsers()).allMatch(x -> x.getEmail().endsWith("@reqres.in"));
  }

  @Test
  @Description("Убедиться, что аватары пользователей начинаются с 'https' и заканчиваются на 'jpg'")
  @Story("Get")
  @Owner("Victor SK")
  public void checkAvatarOfUsers() {
    assertThat(UsersSteps.getListOfUsers())
        .allMatch(x -> x.getAvatar().startsWith("http")).allMatch(x -> x.getAvatar().endsWith("jpg"));
  }

  @Test
  @Description("Убедиться, что id пользователей содержаться в их avatar")
  @Story("Get")
  @Owner("Victor SK")
  public void checkIdAvatar() {
    assertThat(UsersSteps.getListOfUsers()).filteredOn(x -> x.getId().toString().contains(x.getAvatar()));
  }

  @Test
  @Description("Убедиться, что в списке пользователей присутствует email - byron.fields@reqres.in")
  @Story("Get")
  @Owner("Victor SK")
  public void checkEmailUser() {
    assertThat(UsersSteps.getListOfUsers()).extracting(UsersDataRsPojo::getEmail).contains("byron.fields@reqres.in");
  }

  @Test
  @Description("Убедиться, что имя 5 пользователя - George")
  @Story("Get")
  @Owner("Victor SK")
  public void checkNameUser() {
    assertThat(UsersSteps.getListOfUsers())
        .element(4).extracting(UsersDataRsPojo::getFirstName).isEqualTo("George");
  }

  @Test
  @Description("Убедиться, что id пользователей отсортированы по возрастанию")
  @Story("Get")
  @Owner("Victor SK")
  public void checkNumbersOfId() {
    assertThat(UsersSteps.getListOfUsers()).extracting(UsersDataRsPojo::getId).containsSequence(7, 8, 9, 10, 11, 12);
  }
}