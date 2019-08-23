package com.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AgentDetailsPage extends BasePage{
	
	WebDriver driver;
	
	
	//By AgentName = By.xpath("//h4[@class='ui-agent__name']");
	By AgentName = By.xpath("//h1[@class = 'bottom-half']");
	
	
	public AgentDetailsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getAgentdetails(){
		WebElement AgentNameElement = getWebElement(AgentName);
		String AgentName = AgentNameElement.getText();
		return AgentName;
	}
	
	public WebElement getWebElement(By byLocators){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(byLocators));
		WebElement element = driver.findElement(byLocators);
		return element;
	}
}
