package com.ShoppersStack_TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.shopperstack_GenericUtilty.Base_Test;
import com.shopperstack_POM.AddressForm_Page;
import com.shopperstack_POM.Home_Page;
import com.shopperstack_POM.MyAddress_Page;
import com.shopperstack_POM.MyProfile_Page;

public class TC001_Verify_User_Is_AbleTo_Address_or_Not_Test extends Base_Test {
	
		@Test
		public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
			
			Thread.sleep(3000);
			homePage.getSettingBtn().click();
			homePage.getMyProfileBtn().click();
			
			MyProfile_Page myprofilePage= new MyProfile_Page(driver);
			myprofilePage.getMyAddressbtn().click();
			
			Thread.sleep(3000);
			
			MyAddress_Page myaddresspage=new MyAddress_Page(driver);
			myaddresspage.getAddAddress().click();
			
			AddressForm_Page addressformpage=new AddressForm_Page(driver);
			addressformpage.getHome().click();
			
			addressformpage.getName().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 0));
			addressformpage.getHouseInfo().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 1));
			addressformpage.getStreetInfo().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 2));
			addressformpage.getLandmark().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 3));
			webDriver.selectByValue(addressformpage.getCountry(),fileUtility.readPropertyFile("country"));
			webDriver.selectByValue(addressformpage.getState(),fileUtility.readPropertyFile("state"));
			webDriver.selectByValue(addressformpage.getCity(),fileUtility.readPropertyFile("city"));
			addressformpage.getPincode().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 4));
			addressformpage.getPhonenumber().sendKeys(fileUtility.readExcelFile("Sheet1", 1, 5));
			addressformpage.getAddAddress().click();
			
			
			Thread.sleep(3000);
			webDriver.webPageScreenShot(driver);
		
	}


}
