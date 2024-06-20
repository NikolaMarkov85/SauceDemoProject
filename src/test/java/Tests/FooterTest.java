package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class FooterTest extends BaseTest {
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";


    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
    }

    @Test
    public void userCanClickSocialLinks() {

        footerPage.clickOnLinks();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        Assert.assertEquals(driver.switchTo().window(listaTabova.get(3)).getCurrentUrl(), "https://x.com/saucelabs");
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(2)).getCurrentUrl(), "https://www.facebook.com/saucelabs");
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(1)).getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }








//@Test1 public void idi na Twiter{
//footerPage.clickTwiter();
// switchToNewWindow();
//Assert.assertEquals(driver.getCurrentUrl(),"https://x.com/saucelabs");
//}


/*@Test
    public void userCanClickFacebookIcon(){
        footerPage.clickFacebook();
        //switchToNewWindow();
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/saucelabs");
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(1)).getCurrentUrl(),"https://x.com/saucelabs");
    }
    @Test
    public void userCanClickLinkedinIcon(){
        footerPage.clickLinkedin();
        switchToNewWindow();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/company/sauce-labs/");
    }*/

}