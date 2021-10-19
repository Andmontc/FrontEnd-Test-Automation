package org.google.globant.tests;

import org.openqa.selenium.WebDriver;
/**
 * This class manages the webdriver.
 */
public abstract class DriverManager {
  /**
   * The Web driver.
   */
  WebDriver webDriver;

  /**
   * Create web driver.
   */
  abstract void createWebDriver();

  /**
   * Validates that a webdriver instance exists, then quits the webdriver and makes it null
   */
  public void quitDriver() {
    if (webDriver != null) {
      webDriver.quit();
      webDriver = null;
    }
  }

  /**
   * Returns a webdriver instance.
   *
   * @return the web driver
   */
  public WebDriver getWebDriver() {
    if (webDriver == null) {
      createWebDriver();
    }
    return webDriver;
  }
}