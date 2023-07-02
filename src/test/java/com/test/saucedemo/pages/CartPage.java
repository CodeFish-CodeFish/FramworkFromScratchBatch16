package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#checkout")
    private WebElement checkOutButton;

    public void clickCheckOutButton(){
        checkOutButton.click();
    }


}
