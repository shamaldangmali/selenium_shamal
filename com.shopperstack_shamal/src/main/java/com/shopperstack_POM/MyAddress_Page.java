package com.shopperstack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddress_Page {
	
	public MyAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAddress;
	

	@FindBy(xpath="(//span[contains(@class,'MuiButton-startIcon')])[2]")
	private WebElement deleteBtn;
	 
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesBtn;

	public WebElement getAddAddress() {
		return addAddress;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}
	
	

}
