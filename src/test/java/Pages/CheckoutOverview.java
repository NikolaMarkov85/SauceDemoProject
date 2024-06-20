package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.text.DecimalFormat;
import java.util.List;

public class CheckoutOverview {
    WebDriver driver;

    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }
    WebElement titleOverview;
    WebElement priceTotal;
    WebElement finishButton;
    List<WebElement>listaNazivaProdukta;
    List<WebElement>listaCenaProdukta;
    WebElement subtotal;
    WebElement tax;
    WebElement total;

    public WebElement getTitleOverview() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getPriceTotal() {
        return priceTotal;
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }

    public List<WebElement> getListaNazivaProdukta() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<WebElement> getListaCenaProdukta() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public WebElement getSubtotal() {
        return driver.findElement(By.className("summary_subtotal_label"));
    }

    public WebElement getTax() {
        return driver.findElement(By.className("summary_tax_label"));
    }

    public WebElement getTotal() {
        return driver.findElement(By.className("summary_total_label"));
    }

    //------------------------------------------------
    public void clickFinishButton(){
        getFinishButton().click();
    }
   /* public double countTax(double cena){
        double tax= Math.round((cena*0.08)*100)/100.00;
        return tax;
    }*/
    public double countTax(double price){
        double tax=price*0.08;
        //DecimalFormat df = new DecimalFormat("#.##");
        //tax = Double.valueOf(df.format(tax));
        return tax;
    }
    public double roundDec(double value){
        double roundValue=value;
        DecimalFormat df = new DecimalFormat("#.##");
       roundValue  = Double.valueOf(df.format(roundValue));
       return roundValue;
    }
}
