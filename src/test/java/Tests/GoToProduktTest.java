package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoToProduktTest extends BaseTest  {
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
    public void test1() {
        homePage.goToProdukt("Sauce Labs Backpack");
        String expectedText = "Sauce Labs Backpack";
        Assert.assertTrue(produktPage.getBackToPRodukts().isDisplayed());
        Assert.assertEquals(produktPage.getProduktItemTitle().getText(), expectedText);
        Assert.assertTrue(produktPage.getImageProdukt().isDisplayed());


    }
    @Test
    public void canAddToCartFromProduktPage(){
        homePage.goToProdukt("Sauce Labs Backpack");
        produktPage.clickAddToCart();
        Assert.assertEquals(produktPage.getShopingCardNumber().getText(),"1");
        Assert.assertTrue(produktPage.getRemoveButton().isDisplayed());
    }
    @Test
    public void removeFromProduktPage(){
        homePage.goToProdukt("Sauce Labs Backpack");
        produktPage.clickAddToCart();
        produktPage.clickRemoveProdukt();

        Assert.assertTrue(produktPage.getAddToCartButton().isDisplayed());
        //Assert.assertFalse(isElementDisplayed(produktPage.getShopingCardNumber())); // nece neki djavo
    }
    @AfterMethod
    public void teardown(){
        resetAppState();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

}
