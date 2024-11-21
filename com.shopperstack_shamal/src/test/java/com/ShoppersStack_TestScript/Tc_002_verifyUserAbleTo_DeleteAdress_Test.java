package com.ShoppersStack_TestScript;

import org.testng.annotations.Test;

import com.shopperstack_GenericUtilty.Base_Test;
import com.shopperstack_POM.MyAddress_Page;
import com.shopperstack_POM.MyProfile_Page;

public class Tc_002_verifyUserAbleTo_DeleteAdress_Test extends Base_Test {

	@Test
	public void deleteAdress() throws InterruptedException {
		Thread.sleep(3000);
		homePage.getSettingBtn().click();
		homePage.getMyProfileBtn().click();

		MyProfile_Page myprofilePage = new MyProfile_Page(driver);
		myprofilePage.getMyAddressbtn().click();

		Thread.sleep(2000);
		MyAddress_Page myAddressPage = new MyAddress_Page(driver);
		myAddressPage.getDeleteBtn().click();
		Thread.sleep(3000);
		myAddressPage.getYesBtn().click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}

}
