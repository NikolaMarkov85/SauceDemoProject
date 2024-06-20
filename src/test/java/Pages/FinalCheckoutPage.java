package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalCheckoutPage {
    WebDriver driver;

    public FinalCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement titleText;
    WebElement poruka;
    WebElement backToHomeButton;

    public WebElement getPoruka() {
        return driver.findElement(By.className("complete-text"));
    }

    public WebElement getTitleText() {
        return driver.findElement(By.className("complete-header"));
    }

    public WebElement getBackToHomeButton() {
        return driver.findElement(By.id("back-to-products"));
    }
    //--------------------------------------------
    public void clickBackToHome(){
        getBackToHomeButton().click();
    }
}
