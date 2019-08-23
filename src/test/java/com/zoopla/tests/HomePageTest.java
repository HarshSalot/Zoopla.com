package com.zoopla.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.pages.BasePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ForSalePage;
import com.zoopla.util.Constants;
import com.zoopla.util.TimeUtil;

public class HomePageTest {

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
	}
	
	@Test
	public void verifyhomePageTitleTest(){
		Assert.assertEquals(driver.getTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifysearchLocation(){
		homePage.setLocation(prop.getProperty("Location"));
		//Assert.assertTrue(homePage.verifyLocation(prop.getProperty("Location")));
		//String title = "Property for sale in London";
		
		forSalePage = new ForSalePage(driver);
		//String title = forSalePage.getPageHeaderTitle();
		Assert.assertEquals(driver.getTitle(), Constants.FORSAlE_PAGE_TITLE);
		//londonPropertyPage.getPrice();
		//londonPropertyPage.propertyDescription();
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
