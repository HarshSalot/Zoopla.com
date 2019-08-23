package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForSalePage extends BasePage {
	
	WebDriver driver; 
	String rawXpath = "(//li//div[@class='listing-results-wrapper']//a[@class='listing-results-price text-price'])";
	
	By pageHeader = By.xpath("//h1[contains(text(),'Property for sale in London')]");
	By priceList = By.xpath(rawXpath);
	
	public ForSalePage(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public String getPageHeaderTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
		WebElement headerTitle = driver.findElement(pageHeader);
		String title = headerTitle.getText();
		System.out.println(headerTitle.getText());
		return title;
		
	}
	
	public int getRowCount(){
		List<WebElement> rows = driver.findElements(priceList);
		int rowCount = rows.size();
		System.out.println(rowCount);
		
		return rowCount;
	}
	
	public void getPrice(){
		
		int rowCount = getRowCount();
		ArrayList<Integer> priceList = new ArrayList<Integer>();
		
		for(int rowNum=1; rowNum<=rowCount; rowNum++){
			String actualXpath = rawXpath + "["+rowNum+"]";
			String price = driver.findElement(By.xpath(actualXpath)).getText().replaceAll("[^0-9]", "");
			int finalprice = Integer.parseInt(price);
			priceList.add(finalprice);
			
		}
		System.out.println(priceList);
		Collections.sort(priceList, Collections.reverseOrder());
		for(int i :priceList){
			System.out.println(i);
		}
			
	}
	
	public PropertyDtlPage propertyDescription(){
	WebElement selectedProperty = driver.findElement(By.xpath("(//li//div[@class='listing-results-wrapper']//a[@class='listing-results-price text-price'])[5]"));
	
	Actions actions = new Actions(driver);
	actions.moveToElement(selectedProperty).click().build().perform();
		//Actions actions = new Actions(driver);
		//actions.moveToElement(clk).click();
		
		return new PropertyDtlPage(driver);
	}
	
	public PropertyDtlPage getPropertybyPosition()
	{
		WebElement click = driver.findElement(By.xpath("(//li//div[@class='listing-results-wrapper']//a[@class='listing-results-price text-price'])[5]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(click).click().build().perform();
		
		return new PropertyDtlPage(driver);
	}
	
	

}
