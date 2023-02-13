package api.utilities;

import core.utils.UrlUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Spec {

  public static final RequestSpecification RQ_SPEC =
      new RequestSpecBuilder()
          .addFilter(new AllureRestAssured())
          .setBaseUri(UrlUtil.getBaseUrlApi())
          .setContentType(ContentType.JSON)
          .build();
}