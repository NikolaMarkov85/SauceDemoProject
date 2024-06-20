package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement error;


    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getError() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }

    //----------------------------------------------
    public void insertUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }public void insertPassword(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }
    public void clickLoginButton(){
        getLoginButton().click();

    }


}
