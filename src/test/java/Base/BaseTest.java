package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage loginPage;
    public HomePage homePage;
    public ProduktPage produktPage;
    public FooterPage footerPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public CheckoutOverview checkoutOverview;
    public FinalCheckoutPage finalCheckoutPage;



    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        homePage =new HomePage(driver);
        produktPage=new ProduktPage(driver);
        footerPage=new FooterPage(driver);
        cartPage =new CartPage(driver);
        checkOutPage=new CheckOutPage(driver);
        checkoutOverview=new CheckoutOverview(driver);
        finalCheckoutPage=new FinalCheckoutPage(driver);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{element});
    }

    public void waitForElementVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean isElementDisplayed(WebElement element) {
        boolean elementIsDisplayed = false;
        try {
            elementIsDisplayed = element.isDisplayed();
        } catch(Exception ignored) {
        }
        return elementIsDisplayed;
    }
    public void resetAppState(){
        homePage.clickHamburgerMenu();
        waitForElementVisibility(homePage.getResetAppState());
        homePage.clickResetAppState();
        driver.navigate().refresh();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
