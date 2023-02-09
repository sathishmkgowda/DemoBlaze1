package com.Testscripts.DemoBlaze1;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericLib.DemoBlaze1.Base;
import com.genericLib.DemoBlaze1.EventList;
@Listeners(EventList.class)
public class AddToCart extends Base
{
@Test
	public void addToCartTest() throws IOException, InterruptedException
	{
	test=extent.createTest("Add Product to Cart");
	test.pass("Loged into DemoBlasze as  "+fl.getDataFromProperties(propPath, "username"));
	 cu.productName(driver,fl.getDataFromProperties(propPath,"productName")).click();
	 test.pass("Navigated to product details page");
	 hp.getAddToCart().click();
	 test.pass("added the product to cart");
	 cu.waitFortheAlert(driver);
	 cu.acceptAlert(driver);
	 test.pass("accepted the alert");
	 hp.getCart().click();
	 test.pass("navigated to cart page");
	 WebElement productCart = cu.findProductinCart(driver,fl.getDataFromProperties(propPath,"productName"));
	 Assert.assertTrue(productCart.isDisplayed());
	 test.pass("product has been added");
	 hp.getCartDeleteProduct().click();
	 Thread.sleep(2000);
	 try {
		 cu.findProductinCart(driver,fl.getDataFromProperties(propPath,"productName")).isDisplayed();
		 Assert.assertTrue(false);
	 }
	 catch(NoSuchElementException e)
	 {
		 System.out.println("Test Script Passed");
	 }
	 test.pass("Product has been deleted from cart");
	 
 
	}

	
}
