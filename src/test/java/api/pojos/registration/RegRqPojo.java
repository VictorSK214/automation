package api.pojos.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegRqPojo {
  private String email;
  private String password;
}