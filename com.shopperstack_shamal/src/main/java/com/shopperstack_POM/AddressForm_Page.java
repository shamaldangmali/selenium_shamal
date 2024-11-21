package com.shopperstack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressForm_Page {

	public AddressForm_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
    
	@FindBy(id="Home")
	private WebElement home;
	
	@FindBy(id="Name")
	private WebElement name;
	
	@FindBy(id="House/Office Info")
	private WebElement houseInfo;
	
	@FindBy(id="Street Info")
	private WebElement streetInfo;
	
	@FindBy(id="Landmark")
	private WebElement landmark;
	
	@FindBy(id="Country")
	private WebElement country;
	
	@FindBy(id="State")
	private WebElement state;
	
	@FindBy(id="City")
	private WebElement city;
	
	@FindBy(id="Pincode")
	private WebElement pincode;
	
	@FindBy(id="Phone Number")
	private WebElement phonenumber;
	
	@FindBy(xpath ="//button[text()='Add Address']")
	private WebElement addAddress;

	public WebElement getHome() {
		return home;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getHouseInfo() {
		return houseInfo;
	}

	public WebElement getStreetInfo() {
		return streetInfo;
	}

	public WebElement getLandmark() {
		return landmark;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}

	

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getAddAddress() {
		return addAddress;
	}
	
	
}