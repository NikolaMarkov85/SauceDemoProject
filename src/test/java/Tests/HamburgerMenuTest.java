package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HamburgerMenuTest extends BaseTest {
    String validUsername="standard_user";
    String validPassword="secret_sauce";
    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
    }
    @Test
    public void inventoryItemAllItemIsdisplayed(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getAlltItems());
        homePage.getHambrugerList().get(0);
        String expected="All Items";
        Assert.assertEquals(homePage.getHambrugerList().getFirst().getText(),expected);

    }
    @Test
    public void inventoryItemAboutIsdisplayed(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getAbout());
        homePage.getHambrugerList().get(1);
        String expected="About";
        Assert.assertEquals(homePage.getHambrugerList().get(1).getText(),expected);

    }
    @Test
    public void inventoryItemLogoutdisplayed(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getLogoutInHamburgerMenu());
        homePage.getHambrugerList().get(2);
        String expected="Logout";
        Assert.assertEquals(homePage.getHambrugerList().get(2).getText(),expected);

    }
    @Test
    public void inventoryResetAppStateisplayed(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getResetAppState());
        homePage.getHambrugerList().get(3);
        String expected="Reset App State";
        Assert.assertEquals(homePage.getHambrugerList().get(3).getText(),expected);

    }
    @Test
    public void isXbuttonVisible(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getxButton());
        Assert.assertTrue(homePage.getxButton().isDisplayed());

    }
    @Test
    public void isXbuttonworkingProperly(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getxButton());

        homePage.clickXButton();
        wait.until(ExpectedConditions.invisibilityOf(homePage.getxButton()));
        Assert.assertFalse(isElementDisplayed(homePage.getAbout()));
        Assert.assertFalse(isElementDisplayed(homePage.getAlltItems()));
        Assert.assertFalse(isElementDisplayed(homePage.getLogoutInHamburgerMenu()));
        Assert.assertFalse(isElementDisplayed(homePage.getResetAppState()));

        Assert.assertTrue(homePage.getProducts().isDisplayed());
    }@Test
    public void aboutButtonRedirectToLink(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getAbout());
        homePage.clickAboutButton();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://saucelabs.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

    }
   /* @Test
    public void resetAppResetProdukct() throws InterruptedException {
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.addProductInCart("Sauce Labs Bike Light");
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getResetAppState());
        homePage.clickResetAppState();
        driver.navigate().refresh();
        //waitForElementVisibility(homePage.getxButton());
        //homePage.clickXButton();
        //waitForElementVisibility(homePage.getCartIcon());
        wait.until(ExpectedConditions.invisibilityOf(homePage.getShopingCardNumber()));

        Assert.assertFalse(isElementDisplayed(homePage.getShopingCardNumber())); // test ne radi

    }*/
   @AfterMethod
   public void teardown(){
       //resetAppState();
       driver.manage().deleteAllCookies();
       driver.navigate().refresh();
   }


}
