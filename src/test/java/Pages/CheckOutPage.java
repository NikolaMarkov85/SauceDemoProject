package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement cartTitle;
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement zipField;
    WebElement cancelButton;
    WebElement continueButton;
    WebElement errorButton;

    public WebElement getCartTitle() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }
    public WebElement getZipField() {
        return driver.findElement(By.id("postal-code"));
    }
    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getErrorButton() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }

    //----------------------------------------------------------
    public void insertNameField(){
        getFirstNameField().clear();
        getFirstNameField().sendKeys("Nikola");
    }
    public void insertLAstnameField(){
        getLastNameField().clear();
        getLastNameField().sendKeys("MArkov");
    }
    public void insertZipField(){
        getZipField().clear();
        getZipField().sendKeys("032");
    }
    public void clickConntinue(){
        getContinueButton().click();
    }
    public void clickCancel(){
        getCancelButton().click();
    }

}
