package com.objectRepo.DemoBlaze1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage
{
	@FindBy(id="login2")
	private WebElement Login;
	
	@FindBy(id="loginusername")
	private WebElement username;
	
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement LoginButton;
    
    @FindBy(id="nameofuser")
    private WebElement VerifyLogin;
    
    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    private WebElement SamsungGalaxyS6;
    
    @FindBy(xpath ="//a[text()='Add to cart']")
    private WebElement AddToCart;
    
    @FindBy(id="cartur")
    private WebElement Cart;
    
    @FindBy(id="logout2")
    private WebElement Logout;
    
    @FindBy(xpath = "//a[text()='Delete']")
    private WebElement CartDeleteProduct;
    
    //getters

	public WebElement getCartDeleteProduct() {
		return CartDeleteProduct;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public void setLogout(WebElement logout) {
		Logout = logout;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getVerifyLogin() {
		return VerifyLogin;
	}

	public WebElement getSamsungGalaxyS6() {
		return SamsungGalaxyS6;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getCart() {
		return Cart;
	}
    
    
    
	
	

}
