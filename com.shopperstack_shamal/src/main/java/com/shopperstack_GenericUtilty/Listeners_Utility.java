package com.shopperstack_GenericUtilty;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_Utility implements ITestListener{
	
	Java_Utility javaUtility=new Java_Utility();
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)Base_Test.sDriver;
		
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameworkConstant.screenShotPath+javaUtility.localDateTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
		
		
		
	

}
