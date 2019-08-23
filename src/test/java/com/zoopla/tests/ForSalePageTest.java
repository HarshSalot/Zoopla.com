package com.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.pages.BasePage;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.util.TimeUtil;

public class ForSalePageTest extends BasePage {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ForSalePage forSalePage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		forSalePage=homePage.setLocation("London");
	}
	
	@Test
	public void getAllPropertiesPrice(){
		//forSalePage.getPrice();
		TimeUtil.shortWait();
		forSalePage.propertyDescription();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
