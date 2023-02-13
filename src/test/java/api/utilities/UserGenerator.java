package api.utilities;

import api.pojos.createuser.CreateUserRqPojo;
import api.pojos.updateuserdata.UpdateUserDataRqPojo;

public class UserGenerator {
  public static CreateUserRqPojo getVictorUser() {
    return CreateUserRqPojo.builder()
        .name("Victor SK")
        .job("QA Automation")
        .build();
  }

  public static UpdateUserDataRqPojo getShelbyUser() {
    return UpdateUserDataRqPojo.builder()
        .name("Thomas Shelby")
        .job("Peaky Blinders")
        .build();
  }
}