package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.CartPage;
import com.test.saucedemo.pages.CheckOutPage;
import com.test.saucedemo.pages.LoginPage;
import com.test.saucedemo.pages.MainPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class OrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);

    @Given("User provides username and password to login successfully")
    public void userProvidesUsernameAndPasswordToLoginSuccessfully() {
        loginPage.login(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
    }

    @When("User chooses the {string},click add to cart button and validate it is added")
    public void userChoosesTheClickAddToCartButtonAndValidateItIsAdded(String productName) {
        mainPage.chooseProduct(productName);
        mainPage.addingProductToCart();
    }

    @When("User clicks cart icon and checkout button")
    public void userClicksCartIconAndCheckoutButton() {
        mainPage.clickCartIconButton(driver);
        cartPage.clickCheckOutButton();
    }

    @When("User provides {string},{string},{string} to checkout page and click continue button")
    public void userProvidesToCheckoutPageAndClickContinueButton(String firstName, String lastName, String zipCode) {
        checkOutPage.sendUserInformation(firstName, lastName, zipCode);
    }

    @Then("User validates the {string},{string},{string},{string} with {string}% tax rate")
    public void userValidatesTheWithTaxRate(String productName, String itemTotal, String tax, String totalPrice, String taxRate) {
        checkOutPage.validateItemOrderInformation(productName, itemTotal, tax, totalPrice, taxRate);
    }

    @Then("User clicks Finish Button and validate {string} for purchase")
    public void userClicksFinishButtonAndValidateForPurchase(String expectedMessage) {
        checkOutPage.clickFinishButton();
        Assert.assertEquals(expectedMessage, checkOutPage.successMessage());
    }
}
