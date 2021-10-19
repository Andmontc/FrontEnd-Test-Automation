package org.google.globant.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * The type Firefox driver manager.
 */
public final class FirefoxDriverManager extends DriverManager {

  @Override
  void createWebDriver() {
    WebDriverManager.firefoxdriver().setup();
    webDriver = new FirefoxDriver();
    webDriver.manage().window().maximize();
  }
}