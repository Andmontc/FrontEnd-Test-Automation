package org.google.globant.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Base page.
 */
public class BasePage {

  /**
   * The Driver.
   */
  private final WebDriverWait wait;

  protected WebDriver driver;

  /**
   * Instantiates a new Base page.
   *
   * @param Driver the  driver
   */
  public BasePage(WebDriver Driver) {
    PageFactory.initElements(Driver, this);
    wait = new WebDriverWait(Driver, 30);  /* TimeOut in seconds= 30 */
    this.driver = Driver;
  }

  /**
   * Gets wait.
   *
   * @return the wait
   */
  public WebDriverWait getWait() {
    return wait;
  }


  /**
   * Get driver web driver.
   *
   * @return the web driver
   */
  protected WebDriver getDriver() {
    return driver;
  }

  /**
   * Safe click.
   *
   * @param button the element to click
   */
  public void safeClick(WebElement button) {
    getWait().until(ExpectedConditions.elementToBeClickable(button));
    button.click();
  }

  /**
   * Wait visibility of.
   *
   * @param element the element waiting for visibility
   */
  public void waitVisibilityOf(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }
}