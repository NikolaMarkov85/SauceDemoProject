package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Collections;

public class SortProductsTest extends BaseTest {
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
    public void userCanSortProductsAccendingPrice(){
        Select dropdown=new Select(homePage.getSortDropdown());
        homePage.getBeforeFilterPriceList();
        waitForElementVisibility(homePage.getSortDropdown());
        dropdown.selectByVisibleText("Price (low to high)");
        homePage.getAfterFilterPriceList();
        Collections.sort(homePage.getBeforeFilterPriceList());
        Assert.assertEquals(homePage.getBeforeFilterPriceList(), homePage.getAfterFilterPriceList());
    }
   @Test
    public void userCanSortProductsDescendingPrice(){
        Select dropdown=new Select(homePage.getSortDropdown());
        homePage.getBeforeFilterPriceList();
        waitForElementVisibility(homePage.getSortDropdown());
        dropdown.selectByVisibleText("Price (high to low)");
        homePage.getAfterFilterPriceList();
        Collections.sort(homePage.getBeforeFilterPriceList());
        Collections.reverse(homePage.getBeforeFilterPriceList());
        Assert.assertEquals(homePage.getBeforeFilterPriceList(), homePage.getAfterFilterPriceList());
    }
    @Test
    public void userCanSortProductsAccendingTitles(){
        Select dropdown=new Select(homePage.getSortDropdown());
        homePage.getBeforeFilterNameList();
        dropdown.selectByVisibleText("Name (A to Z)");
        homePage.getAfterFilterNameList();
        Collections.sort(homePage.getBeforeFilterNameList());
        Assert.assertEquals(homePage.getBeforeFilterNameList(), homePage.getAfterFilterNameList());
    }
    @Test
    public void userCanSortProductsDescendingTitles(){
        Select dropdown=new Select(homePage.getSortDropdown());
        homePage.getBeforeFilterNameList();
        dropdown.selectByVisibleText("Name (Z to A)");
        homePage.getAfterFilterNameList();
        Collections.sort(homePage.getBeforeFilterNameList());
        Collections.reverse(homePage.getBeforeFilterNameList());
        Assert.assertEquals(homePage.getBeforeFilterNameList(), homePage.getAfterFilterNameList());
    }
    @AfterMethod
    public void clean() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}