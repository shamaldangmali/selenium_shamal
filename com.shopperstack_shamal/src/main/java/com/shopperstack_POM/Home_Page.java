package com.shopperstack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   
	@FindBy(xpath =" //span[contains(@class ,'BaseBadge-badge')]")
	private WebElement settingBtn;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileBtn;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logoutbtn;

	

	public WebElement getSettingBtn() {
		return settingBtn;
	}

	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	
}
