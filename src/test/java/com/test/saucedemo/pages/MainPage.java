package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> allProducts;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[.='Add to cart']")
    private WebElement addToCartButton;

    public void chooseProduct(String productName) {
        for (WebElement product : allProducts) {
            if (BrowserUtils.getText(product).equals(productName)) {
                product.click();
                break;
            }
        }
    }

    public void addingProductToCart(){
        Assert.assertTrue(BrowserUtils.getText(cartIcon).isEmpty());
        addToCartButton.click();
        Assert.assertFalse(BrowserUtils.getText(cartIcon).isEmpty());
    }

    public void clickCartIconButton(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        cartIcon=wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }
}
