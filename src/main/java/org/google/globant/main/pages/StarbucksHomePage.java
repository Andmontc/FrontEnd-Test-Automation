package org.google.globant.main.pages;

import com.google.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Starbucks home page.
 */
public class StarbucksHomePage extends BasePage {

  /**
   * The Logger.
   */
  Logger logger = Logger.getLogger(StarbucksHomePage.class.getName());

  @FindBy(className = "tab")
  private List<WebElement> elementsOfTheNavbarMenu;

  @FindBy(linkText = "Café en grano")
  private WebElement coffeeTypeLink;

  @FindBy(className = "format")
  private WebElement prepareCheck;

  @FindBy(className = "caffeine")
  private WebElement prepareCoffeeCheckbox;

  @FindBy(className = "isflavored")
  private WebElement flavoredCheck;

  @FindBy(className = "buy")
  private WebElement buyCheck;

  @FindBy(id = "CoffeeCount")
  private WebElement coffeeText;

  @FindBy(linkText = "Estado de cuenta")
  private WebElement accountLink;

  @FindBy(linkText = "Localiza tu tienda Starbucks")
  private WebElement shopLink;

  @FindBy(css = "div[class='coffeeItem']")
  private List<WebElement> coffeeOptions;

  @FindBy(css = "div[class='column size12of12 sm_size7of12 lg_size5of12']")
  private WebElement coffeeDescription;

  /**
   * Instantiates a new Base page.
   *
   * @param Driver the p driver
   */

  @Inject
  public StarbucksHomePage(WebDriver Driver) {
    super(Driver);
    driver.get("https://www.starbucks.com.mx");
  }

  /**
   * Check menu list boolean.
   *
   * @return the boolean
   */
  public Boolean checkIfMenuListIsDisplayed() {
    String[] checkName = {"CAFÉ", "MENÚ", "TIENDAS", "IMPACTO SOCIAL", "STARBUCKS",
        "STARBUCKS REWARDS", "BLOG"};
    int count = 0;

    for (int i = 0; i <= 6; i++) {
      if (!Objects.equals(elementsOfTheNavbarMenu.get(i).getText(), checkName[count])) {
        return false;
      }
      count++;
    }
    return true;
  }

  /**
   * Select coffee string.
   *
   * @return the string to test
   */
  public String selectCoffee() throws InterruptedException {
    WebElement coffee = elementsOfTheNavbarMenu.get(0);
    safeClick(coffee);
    safeClick(coffeeTypeLink);
    safeClick(prepareCheck);
    safeClick(prepareCoffeeCheckbox);
    safeClick(flavoredCheck);
    safeClick(buyCheck);
    waitVisibilityOf(coffeeText);
    if (coffeeText.getText() == null) {
      return "Text missing";
    }
    logger.info(coffeeText.getText());
    return coffeeText.getText();
  }

  /**
   * Learn more about coffee boolean.
   *
   * @return the boolean
   */
  public Boolean checkPresenceOfCoffeeDescription() throws InterruptedException {
    WebElement coffee = coffeeOptions.get(4);
    coffee.findElement(By.className("more")).click();
    waitVisibilityOf(coffeeDescription);
    logger.info(coffeeDescription.getText());
    return coffeeDescription.isDisplayed();
  }

  /**
   * Gets rewards page.
   *
   * @return the rewards page
   */
  public RewardsPage getRewardsPage() {
    WebElement rewards = elementsOfTheNavbarMenu.get(5);
    safeClick(rewards);
    safeClick(accountLink);
    return new RewardsPage(getDriver());
  }
}
