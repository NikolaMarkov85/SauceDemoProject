package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement cartTitle;
    List<WebElement>listaNazivaProizvodaUCartu;
    List<WebElement>listaCenaProizvodaUCartu;
    //List<WebElement>listaRemoveButtonaUCartu;
    WebElement checkOutButton;


    public WebElement getCartTitle() {
        return driver.findElement(By.cssSelector(".header_secondary_container .title"));
    }

    public List<WebElement> getListaNazivaProizvodaUCartu() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public List<WebElement> getListaCenaProizvodaUCartu() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public List<WebElement> getListaRemoveButtonaUCartu() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }

    public WebElement getCheckOutButton() {
        return driver.findElement(By.id("checkout"));
    }
//------------------------------
    public void clickCheckout(){
        getCheckOutButton().click();
    }
}
