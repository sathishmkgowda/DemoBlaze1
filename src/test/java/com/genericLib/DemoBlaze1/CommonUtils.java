package com.genericLib.DemoBlaze1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils
{ 
	WebDriverWait wait;
	public WebElement productName(WebDriver driver,String productName) 
	{
	return	driver.findElement(By.xpath("//a[text()='"+productName+"']"));	
	}
	
	public WebElement findProductinCart(WebDriver driver,String productName) 
	{
	return	driver.findElement(By.xpath("//td[text()='"+productName+"']"));	
	}
	
	public void waitFortheText(WebDriver driver,WebElement e,String text)
	{
	    wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBePresentInElement(e, text));
		
	}
	
	public void acceptAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	public void waitFortheAlert(WebDriver driver) {
		  wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void waitFortheElemenToBeCickable(WebDriver driver,WebElement e) {
		  wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.elementToBeClickable(e));
       
	}
}
