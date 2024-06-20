package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    String validUsername="standard_user";
    String validPassword="secret_sauce";

public void goToCheckOut(){
    homePage.addProductInCart("Sauce Labs Backpack");
    homePage.addProductInCart("Sauce Labs Fleece Jacket");
    homePage.clickCartIcon();
    cartPage.clickCheckout();
    checkOutPage.insertNameField();
    checkOutPage.insertLAstnameField();
    checkOutPage.insertZipField();
    checkOutPage.clickConntinue();
}
    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
    }
    @Test
    public void verifyUserIsOnCheckoutPage() {
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        Assert.assertEquals(checkOutPage.getCartTitle().getText(), "Checkout: Your Information");

    }
    /*@Test
    public void verifyInputFieldsAreSent() {
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        checkOutPage.insertNameField();
        checkOutPage.insertLAstnameField();
        checkOutPage.insertZipField();
        Assert.assertEquals(checkOutPage.getFirstNameField().getText(),"Nikola");
        Assert.assertEquals(checkOutPage.getLastNameField().getText(),"MArkov");
        Assert.assertEquals(checkOutPage.getZipField().getText(),"032");

    }*/
    @Test
    public void userCannotCheckOutEmptyField(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        checkOutPage.clickConntinue();
        Assert.assertTrue(checkOutPage.getContinueButton().isDisplayed());
        Assert.assertEquals(checkOutPage.getErrorButton().getText(),"Error: First Name is required");

    }
    @Test
    public void userCannotCheckOutEmptyLastnameField(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        checkOutPage.insertNameField();
        checkOutPage.insertZipField();
        checkOutPage.clickConntinue();
        Assert.assertTrue(checkOutPage.getContinueButton().isDisplayed());
        Assert.assertEquals(checkOutPage.getErrorButton().getText(),"Error: Last Name is required");
    }
    @Test
    public void userCanCancelCheckout(){
        homePage.addProductInCart("Sauce Labs Backpack");
        homePage.clickCartIcon();
        cartPage.clickCheckout();
        checkOutPage.clickCancel();
        //Assert.assertFalse(isElementDisplayed(checkOutPage.getCancelButton()));
        Assert.assertTrue(cartPage.getCheckOutButton().isDisplayed());
        Assert.assertTrue(cartPage.getCartTitle().isDisplayed());
    }
    @Test
    public void userCanGoToCheckoutOverviewPage(){
        goToCheckOut();
        Assert.assertEquals(checkoutOverview.getTitleOverview().getText(),"Checkout: Overview");
        Assert.assertTrue(checkoutOverview.getFinishButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }
    @Test
    public void verifyProductsAreInCheckOverviewPage(){
        goToCheckOut();
        WebElement prviNaziv=checkoutOverview.getListaNazivaProdukta().getFirst();
        WebElement prviCena=checkoutOverview.getListaCenaProdukta().getFirst();
        WebElement drugiNaziv=checkoutOverview.getListaNazivaProdukta().get(1);
        WebElement drugiCena=checkoutOverview.getListaCenaProdukta().get(1);

        Assert.assertEquals(prviNaziv.getText(),"Sauce Labs Backpack");
        Assert.assertEquals(drugiNaziv.getText(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(prviCena.getText(),"$29.99");
        Assert.assertEquals(drugiCena.getText(),"$49.99");
    }
    @Test
    public void verifyTotalPrice(){
        goToCheckOut();
        WebElement prviCena=checkoutOverview.getListaCenaProdukta().getFirst();
        WebElement drugiCena=checkoutOverview.getListaCenaProdukta().get(1);
        String str1= prviCena.getText();
        String str2=drugiCena.getText();
        double cena1=Double.valueOf(str1.replace("$",""));
        double cena2=Double.valueOf(str2.replace("$",""));
        double cena=cena1+cena2;
        double rooundCena=checkoutOverview.roundDec(cena);
        double tax=checkoutOverview.countTax(cena);
        double roundTax=checkoutOverview.roundDec(tax);
        double sumPrice=cena+roundTax;
        double roundSum=checkoutOverview.roundDec(sumPrice);
        Assert.assertEquals((checkoutOverview.getSubtotal().getText()),("Item total: $"+cena));
        //Assert.assertEquals(checkoutOverview.getTax().getText(),"Total: $"+tax);
        Assert.assertEquals(checkoutOverview.getTotal().getText(),("Total: $"+roundSum));
    }

    @Test
    public void userCanGoToFinalCheckOutPage(){
        goToCheckOut();
        checkoutOverview.clickFinishButton();
        Assert.assertEquals(finalCheckoutPage.getTitleText().getText(),"Thank you for your order!");
        Assert.assertEquals(finalCheckoutPage.getPoruka().getText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Assert.assertEquals(finalCheckoutPage.getBackToHomeButton().getText(),"Back Home");
        Assert.assertTrue(finalCheckoutPage.getBackToHomeButton().isDisplayed());
    }
    @Test
    public void userCanGoToHomePAge(){
        goToCheckOut();
        checkoutOverview.clickFinishButton();
        finalCheckoutPage.clickBackToHome();
        Assert.assertEquals(homePage.getProducts().getText(),"Products");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


    }
    @AfterMethod
    public void teardown(){
        resetAppState();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }


}

