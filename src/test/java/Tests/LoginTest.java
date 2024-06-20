package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String validUsername="standard_user";
    String validPassword="secret_sauce";
    String userNameFirstLetterisUpper="Standard_user";
    String userNameAllUppercase="STANDARD_USER";
    String invalidPassword="password1";
    String invalidUsername="username1";
    String passwordFirstletterUpper="Secret_sauce";
    String passwordALLUppercase="SECRET_SAUCE";

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }
    @Test(priority = 10)

    public void userCanLoginWithValidCredentials(){
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getProducts().getText(),"Products");
        Assert.assertEquals(homePage.getSwaglabLogo().getText(),"Swag Labs");

    }
    @Test (priority = 20)
    public void userCanotLoginInvalidUsernameFirstLetterUpper(){

        loginPage.insertUsername(userNameFirstLetterisUpper);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 30)
    public void userCannotLoginInvalidUsernamAllUpper(){
        loginPage.insertUsername(userNameAllUppercase);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match any user in this service");

    }
    @Test (priority = 40)
    public void userCanotLoginInvalidPassword(){
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 50)
    public void userCannotLoginInvalidusernameInvalidpassword(){
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
    @Test(priority = 60)
    public void usercannotLoginValidUsernamePasswordUppercase(){
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(passwordALLUppercase);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
    @Test(priority = 70)
    public void userCannotLoginValidUsernamePAsswordFirstletterUpper(){
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(passwordFirstletterUpper);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
    @Test(priority = 80)
    public void userCannotLoginUsernameAllUpperPasswordAllUpper(){
        loginPage.insertUsername(userNameAllUppercase);
        loginPage.insertPassword(passwordALLUppercase);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginPage.getError().getText(),"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
    @AfterMethod
    public void clean(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
