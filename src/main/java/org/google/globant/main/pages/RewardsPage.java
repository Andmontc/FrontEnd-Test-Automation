package org.google.globant.main.pages;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * The type Rewards page.
 */
public class RewardsPage extends BasePage {

  /**
   * The Logger.
   */
  Logger logger = Logger.getLogger(RewardsPage.class.getName());

  @FindBy(id = "navbarDropdown")
  private List<WebElement> elementsOfTheNavbarMenu;
  @FindBy(linkText = "Inicia Sesión")
  private WebElement login;
  @FindBy(id = "normal_login_email")
  private WebElement emailInput;
  @FindBy(id = "normal_login_password")
  private WebElement passwordInput;
  @FindBy(css = "button[type='submit'")
  private WebElement submitButton;
  @FindBy(css = "div[class='jsx-3132379493 form-group mt-3 mb-3 capcha-has-error']")
  private WebElement captchaText;
  @FindBy(css = "div[class='jsx-3132379493 background']")
  private WebElement loginLoad;
  @FindBy(linkText = "Localiza tu tienda Starbucks")
  private WebElement shopLink;

  /**
   * Instantiates a new Rewards page.
   *
   * @param driver the driver
   */
  public RewardsPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Check captcha boolean.
   *
   * @param email    the email
   * @param password the password
   * @return the boolean
   */

  public void enterEmail(String email) throws InterruptedException {
    safeClick(login);
    waitVisibilityOf(loginLoad);
    safeClick(emailInput);
    emailInput.sendKeys(email);
  }

  public void enterPassword(String password) throws InterruptedException {
    safeClick(passwordInput);
    passwordInput.sendKeys(password);
  }

  public Boolean captchaIsDisplayed(String email, String password) throws InterruptedException {
    enterEmail(email);
    enterPassword(password);
    submitButton.click();
    return captchaText.isDisplayed();
  }

  /**
   * Gets shop page.
   *
   * @return the shop page driver
   */
  public ShopsPage getShopPage() throws InterruptedException {
    WebElement shop = elementsOfTheNavbarMenu.get(3);
    safeClick(shop);
    safeClick(shopLink);
    return new ShopsPage(getDriver());
  }

}
