package com.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zoopla.util.TimeUtil;

import bsh.util.Util;



public class HomePage extends BasePage {
	WebDriver driver;
	    // By Locators
		By searchLocation = By.xpath("//input[@id='search-input-location']");
		By lblLocation = By.id("search-input-location");
		By btnSubmit = By.xpath("//button[@type='submit']"); 
		

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public boolean verifyLocation(String location)

	{
		WebElement Location = driver.findElement(lblLocation);
		return Location.getText().contains(location);
	}
	
	public ForSalePage setLocation(String Location){
		
		WebElement inputLocation = driver.findElement(searchLocation);
		
		inputLocation.sendKeys("London");
		//inputLocation.click();
		WebElement searchButton = driver.findElement(btnSubmit);
		searchButton.click();
		//Actions actions = new Actions(driver);
		//actions.moveToElement(searchButton).click().build().perform();
		return new ForSalePage(driver);
		
	}
	
	

}
