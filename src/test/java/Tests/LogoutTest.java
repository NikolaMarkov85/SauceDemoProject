package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {
    String validUsername="standard_user";
    String validPassword="secret_sauce";
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
    }
    @Test
    public void test1() throws InterruptedException {
        //
        homePage.clickHamburgerMenu();
        //wait.until(ExpectedConditions.visibilityOf(productsPage.getLogoutInHamburgerMenu()));
        waitForElementVisibility(homePage.getLogoutInHamburgerMenu());
        homePage.clickOnHamburgerItemList("Logout");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Boolean swaglogo=false;
        try {
            swaglogo= homePage.getSwaglabLogo().isDisplayed();
        }catch(Exception e){
            System.out.println("Logo ostao vidljiv, user nije izlogovan");
        }
        Assert.assertFalse(swaglogo);

       // wait.until(ExpectedConditions.invisibilityOf(homePage.getHamburgerMenu()));
       // Assert.assertFalse(isElementDisplayed(homePage.getLogoutInHamburgerMenu()));

    }
    @AfterMethod
    public void clean() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
