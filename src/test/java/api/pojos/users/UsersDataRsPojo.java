package api.pojos.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersDataRsPojo {
  private Integer id;
  private String email;
  @JsonProperty("first_name")
  private String firstName;
  private String avatar;
}