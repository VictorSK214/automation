package core.utils;

import lombok.SneakyThrows;

public class UrlUtil {

  @SneakyThrows
  public static String getBaseUrl() {
    System.getProperties().load(ClassLoader.getSystemResourceAsStream("url.properties"));
    return System.getProperty("base.url");
  }

  @SneakyThrows
  public static String getBaseUrlApi() {
    System.getProperties().load(ClassLoader.getSystemResourceAsStream("url.properties"));
    return System.getProperty("base.url.api");
  }
}