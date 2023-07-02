package com.test.saucedemo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {

    public WebDriver driver= DriverHelper.getDriver();

    @Before
    public void setup(){
       driver.get(ConfigReader.readProperty("QA_sauceDemo_url"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
       driver.quit();
    }

}
