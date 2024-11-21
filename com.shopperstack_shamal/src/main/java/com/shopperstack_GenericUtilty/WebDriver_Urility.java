package com.shopperstack_GenericUtilty;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v128.page.model.Screenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Urility {
	Java_Utility javauUtility=new Java_Utility();
	
	public void selectByValue(WebElement element,String value) {
	Select sel=new Select(element);
	sel.selectByValue(value);

}
	public void webPageScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(FrameworkConstant.screenShotPath+javauUtility.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
	
	public void WebElementscreenShot(WebElement element) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameworkConstant.screenShotPath+javauUtility.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
}