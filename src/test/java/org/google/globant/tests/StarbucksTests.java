package org.google.globant.tests;

import static com.google.common.truth.Truth.assertThat;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.google.globant.main.pages.RewardsPage;
import org.google.globant.main.pages.ShopsPage;
import org.google.globant.main.pages.StarbucksHomePage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * The type Starbucks tests.
 */
@RunWith(JUnit4.class)
public class StarbucksTests {

  /**
   * The Injector.
   */
  Injector injector = Guice.createInjector(new DriverModule());
  /**
   * The Driver manager.
   */
  FirefoxDriverManager driverManager = injector.getInstance(FirefoxDriverManager.class);
  /**
   * The Home.
   */
  StarbucksHomePage home = injector.getInstance(StarbucksHomePage.class);


  /**
   * Dispose.
   */
  @After
  public void dispose() {
    driverManager.quitDriver();
  }


  @Test
  public void checkElementsInMenuList() {
    assertThat(home.checkIfMenuListIsDisplayed()).isTrue();
  }

  @Test
  public void checkCoffeeText() throws Exception {
    assertThat(home.selectCoffee()).isEqualTo("Encontramos 14 café que concuerda con su selección");
    assertThat(home.checkPresenceOfCoffeeDescription()).isTrue();
  }

  @Test
  public void checkCaptchaText() throws Exception {
    RewardsPage rewards = home.getRewardsPage();

    assertThat(rewards.captchaIsDisplayed("Andres@globant.com", "wasd1234")).isTrue();
  }

  @Test
  public void checkShopAddress() throws Exception {
    RewardsPage rewards = home.getRewardsPage();
    ShopsPage shop = rewards.getShopPage();

    assertThat(shop.searchAddress()).isEqualTo(5);
    assertThat(shop.searchAddress()).isNotNull();
  }
}