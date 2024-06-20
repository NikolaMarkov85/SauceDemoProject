package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement swaglabLogo;
    WebElement products;
    WebElement shopingCardNumber;
    WebElement hamburgerMenu;
    WebElement alltItems;
    WebElement about;
    WebElement resetAppState;
    WebElement logoutInHamburgerMenu;
    WebElement xButton;


    List<WebElement>hambrugerList;
    WebElement sortDropdown;
    List<WebElement>beforeProductsPrices;
    List<WebElement>productTitleList;
    List<WebElement>proizvodi;
    WebElement addToCartButton;
    WebElement cartIcon;




    public WebElement getSwaglabLogo() {
        return driver.findElement(By.className("app_logo"));
    }

    public WebElement getProducts() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getHamburgerMenu() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public WebElement getShopingCardNumber() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }
   /* public WebElement getShopingCardNumber() {
        return driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
    }*/

    public WebElement getAlltItems() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getAbout() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getResetAppState() {
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public WebElement getLogoutInHamburgerMenu() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getxButton() {
        return driver.findElement(By.className("bm-cross-button"));
    }

    public List<WebElement> getHambrugerList() {
        return driver.findElements(By.cssSelector(".bm-item.menu-item"));
    }

    public WebElement getSortDropdown() {
        return driver.findElement(By.className("product_sort_container"));
    }

    public List<WebElement> getBeforeProductsPrices() {

        return driver.findElements(By.className("inventory_item_price"));
    }

    public List<WebElement> getProductTitleList() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<WebElement> getProizvodi() {
        return driver.findElements(By.cssSelector(".inventory_list .inventory_item"));
    }
    public String getProductName(WebElement product) {
        return product.findElement(By.className("inventory_item_name")).getText();
    }
    public String getProductPrice(WebElement product) {
        return product.findElement(By.className("inventory_item_price")).getText();
    }
    public WebElement getCartIcon() {
        return driver.findElement(By.className("shopping_cart_link"));
    }
    //------------------------------------------------
    public void clickHamburgerMenu(){
        getHamburgerMenu().click();
    }
    public void clickLogoutInHamburgerMenu(){
        getLogoutInHamburgerMenu().click();
    }
    public void  clickOnHamburgerItemList(String hamburgerName) {
        for (int i = 0; i < getHambrugerList().size(); i++) {
            if (getHambrugerList().get(i).getText().equals(hamburgerName)) {
                getHambrugerList().get(i).click();
                break;
            }
        }
    }
    public void clickXButton(){
        getxButton().click();
    }
    public void clickAboutButton(){
        getAbout().click();
    }
    public void clickResetAppState(){
        getResetAppState().click();
    }

    //sortiranje
   // ---------------------------------------------------------------------
    public List<Double>getBeforeFilterPriceList(){
        List<Double>productPrices=new ArrayList<>();
        for (WebElement price:getBeforeProductsPrices()){
            productPrices.add(Double.valueOf(price.getText().replace("$","")));
        }
        return productPrices;
    }
    public List<Double>getAfterFilterPriceList(){
        List<Double>productPrices=new ArrayList<>();
        for (WebElement price:getBeforeProductsPrices()){
            productPrices.add(Double.valueOf(price.getText().replace("$","")));
        }
        return productPrices;
    }
    public List<String>getBeforeFilterNameList(){
        List<String>productsNames=new ArrayList<>();
        for(WebElement name:getProductTitleList()){
            productsNames.add(name.getText());
        }
        return productsNames;
    }
    public List<String>getAfterFilterNameList(){
        List<String>productsNames=new ArrayList<>();
        for(WebElement name:getProductTitleList()){
            productsNames.add(name.getText());
        }
        return productsNames;
    }
    //----------------------------------------
    public void goToProdukt(String nameOfProdukt){
        for(int i=0;i<getProductTitleList().size();i++){
            if(getProductTitleList().get(i).getText().equals(nameOfProdukt)){
                getProductTitleList().get(i).click();
                break;
            }
        }
    }
    public void clickOnProductButton(WebElement product) {
        product.findElement(By.className("btn_inventory")).click();
    }

    public void addProductInCart(String productName) {
        for(WebElement product : getProizvodi()) {
            if(getProductName(product).equals(productName)) {
                clickOnProductButton(product);
                break;
            }
        }
    }
    public void removeProduct( String productName){
        for(WebElement product:getProizvodi()){
            if(getProductName(product).equals(productName)){
                clickOnProductButton(product);
            }
        }
    }
    public void clickCartIcon(){
        getCartIcon().click();
    }

}
