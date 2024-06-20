package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterPage {
    WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }
    List<WebElement>links;
    WebElement twiterIcon;
    WebElement facebookIcon;
    WebElement linkedinIcon;

    public WebElement getTwiterIcon() {
        return driver.findElement(By.cssSelector("[data-test='social-twitter'"));
    }

    public WebElement getLinkedinIcon() {
        return driver.findElement(By.cssSelector("[data-test='social-linkedin'"));
    }

    public WebElement getFacebookIcon() {
        return driver.findElement(By.cssSelector("[data-test='social-facebook'"));
    }

    public List<WebElement> getLinks() {
        return driver.findElements(By.cssSelector("ul.social>li"));
    }
//---------------------------------------------

    public void clickTwiter(){
        getTwiterIcon().click();
    }
    public void clickFacebook(){
        getFacebookIcon().click();
    }
    public void clickLinkedin(){
        getLinkedinIcon().click();
    }
    public void clickOnLinks(){
        for (WebElement element:getLinks()){
            element.click();
        }
    }
}
