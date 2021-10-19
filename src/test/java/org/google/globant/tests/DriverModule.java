package org.google.globant.tests;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;

/**
 * The type Driver module.
 */
public class DriverModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(DriverManager.class).to(FirefoxDriverManager.class).in(Scopes.SINGLETON);
  }

  /**
   * Gets driver.
   *
   * @param driverManager the driver manager
   * @return the driver
   */
  @Provides
  public WebDriver getDriver(DriverManager driverManager) {
    return driverManager.getWebDriver();
  }
}
