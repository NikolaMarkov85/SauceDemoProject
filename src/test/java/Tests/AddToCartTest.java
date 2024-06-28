package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
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
    public void userCanAddToCart(){
        homePage.addProductInCart("Sauce Labs Backpack");
        Assert.assertEquals(produktPage.getShopingCardNumber().getText(),"1");

    }
    @Test
    public void userCanAddMultipleProductsInCart(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.addProductInCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(produktPage.getShopingCardNumber().getText(),"2");
    }
    @Test
    public void verifyProductsAreInCart(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.addProductInCart("Sauce Labs Fleece Jacket");
        homePage.clickCartIcon();
        WebElement prvi= cartPage.getListaNazivaProizvodaUCartu().getFirst();
        WebElement drugi= cartPage.getListaNazivaProizvodaUCartu().get(1);
        Assert.assertEquals(produktPage.getShopingCardNumber().getText(),"2");
        Assert.assertEquals(cartPage.getCartTitle().getText(),"Your Cart");
        Assert.assertEquals(prvi.getText(),"Sauce Labs Backpack");
        Assert.assertEquals(drugi.getText(),"Sauce Labs Fleece Jacket");
    }
    @Test
    public void verifyProductsPriceAreInCart() {
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.addProductInCart("Sauce Labs Fleece Jacket");
        homePage.clickCartIcon();
        WebElement prvi= cartPage.getListaCenaProizvodaUCartu().getFirst();
        WebElement drugi= cartPage.getListaCenaProizvodaUCartu().get(1);
        Assert.assertEquals(prvi.getText(),"$29.99");
        Assert.assertEquals(drugi.getText(),"$49.99");
    }
    @AfterMethod
    public void clean(){
        resetAppState();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }



}
