package core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface LoginProvider {
  static Config readConfig() {
    return ConfigFactory.load("logindata.json");
  }

  String PASSWORD = readConfig().getString("loginData.password");
  String STANDARD_USER = readConfig().getString("loginData.standardUser");
  String LOCKED_OUT_USER = readConfig().getString("loginData.lockedOutUser");
  String PROBLEM_USER = readConfig().getString("loginData.problemUser");
  String PERFORMANCE_GLITCH_USER = readConfig().getString("loginData.performanceGlitchUser");
}