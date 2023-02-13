package api.pojos.createuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRsPojo extends CreateUserRqPojo{
  private String createdAt;
}