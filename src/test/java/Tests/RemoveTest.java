package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveTest extends BaseTest {
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
    public void canUserRemoveProdukt(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.addProductInCart("Sauce Labs Fleece Jacket");
        homePage.removeProduct("Sauce Labs Backpack");

        Assert.assertEquals(homePage.getShopingCardNumber().getText(),"1");



    }
}
