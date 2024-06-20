package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProduktPage {
    WebDriver driver;

    public ProduktPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement backToPRodukts;
    WebElement produktItemTitle;
    WebElement addToCartButton;
    WebElement shopingCardNumber;
    WebElement imageProdukt;
    WebElement removeButton;

    public WebElement getBackToPRodukts() {
        return driver.findElement(By.name("back-to-products"));
    }

    public WebElement getProduktItemTitle() {
        return driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart"));
    }

    /*public WebElement getShopingCardNumber() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }*/
    public WebElement getShopingCardNumber() {
        return driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
    }

    public WebElement getImageProdukt() {
        return driver.findElement(By.className("inventory_details_img_container"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove"));
    }

    //----------------------------------------------------
    public void clickBackToPRodukts(){
        getBackToPRodukts().click();
    }
    public void clickAddToCart(){
        getAddToCartButton().click();
    }
    public void clickRemoveProdukt(){
        getRemoveButton().click();
    }

}
