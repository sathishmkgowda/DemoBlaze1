package com.genericLib.DemoBlaze1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class EventList implements ITestListener 
{

	@Override
	public void onTestFailure(ITestResult result) {
	
		File src=((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("test-output/Screenshots/"+System.currentTimeMillis()+".png");
		String path = dest.getAbsolutePath(); 	
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Base.test.fail("test case failed"+result.getThrowable().toString(),MediaEntityBuilder.createScreenCaptureFromPath("").build());
	}
	 

}
