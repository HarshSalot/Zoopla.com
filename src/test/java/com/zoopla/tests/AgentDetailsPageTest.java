package com.zoopla.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.pages.AgentDetailsPage;
import com.zoopla.pages.BasePage;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDtlPage;
import com.zoopla.util.TimeUtil;

public class AgentDetailsPageTest extends BasePage {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	AgentDetailsPage agentDetailsPage;
	String s;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		forSalePage=homePage.setLocation("London");
		TimeUtil.mediumWait();
		propertyDtlPage = forSalePage.propertyDescription();
		TimeUtil.shortWait();
		s = propertyDtlPage.getAgentProfile();
		agentDetailsPage = new AgentDetailsPage(driver);
		TimeUtil.shortWait();
	}
	
	@Test
	public void verifyAgentDetailTest(){
		String AgentName = agentDetailsPage.getAgentdetails();
		Assert.assertEquals(s, AgentName.substring(0, AgentName.indexOf(",")));
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
