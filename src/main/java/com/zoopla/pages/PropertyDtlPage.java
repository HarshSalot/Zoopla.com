package com.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyDtlPage extends BasePage {
	
	WebDriver driver;
	
	By AgentName = By.xpath("//h4[@class='ui-agent__name']");
	By AgentAddress = By.xpath("//address[contains(@class, 'address')]");
	By AgentLogo = By.xpath("//div[contains(@class,'logo')]/img");
	
	public PropertyDtlPage(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public String getAgentdetails()
	{
		System.out.println("Agent Details:");	
		 String agentName= getWebElement(AgentName).getText(); 
		System.out.println("Name="+agentName);
		System.out.println("Address="+getWebElement(AgentAddress).getAttribute("innerHTML"));
		System.out.println("Logo Text="+getWebElement(AgentLogo).getAttribute("alt"));
		//System.out.println("Phone Number="+getWebElement(byLocators).getAttribute("href").replaceAll("tel:" , ""));
		return agentName;
	}
	
	
	public WebElement getWebElement(By byLocators){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(byLocators));
		WebElement element = driver.findElement(byLocators);
		return element;
	}
	
	public String getAgentProfile(){
		String s = getAgentdetails();
		getWebElement(AgentName).click();
		
		return s;
	}
	

}
