package org.google.globant.main.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Shops page.
 */
public class ShopsPage extends BasePage {

  @FindBy(id = "searchField")
  private WebElement addressInput;
  @FindBy(xpath = "//*[@id=\"searchResults\"]/li[1]")
  private WebElement addressOptions;
  @FindBy(id = "store-infowindow")
  private WebElement storeInfo;

  /**
   * Instantiates a new Shops page.
   *
   * @param driver the driver
   */
  public ShopsPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Search address of all shops in the array.
   *
   * @return the amount of address displayed
   */
  public int searchAddress() throws InterruptedException {
    String[] cities = {"Imbanaco Cali", "Granada Cali", "Unicentro-Cali", "Chipichape Cali",
        "Jardin Plaza Cali"};
    List<WebElement> infoAddress = new ArrayList<WebElement>();
    for (String city : cities) {
      safeClick(addressInput);
      addressInput.clear();
      addressInput.sendKeys(city, Keys.ENTER);
      safeClick(addressOptions);
      infoAddress.add(storeInfo);
    }
    if (infoAddress.size() == cities.length) {
      return infoAddress.size();
    } else {
      return 0;
    }
  }
}
