package projectBase.Scripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import adminSection.Pages.*;

public class ScreenshotBase {
	WebDriver driver;
	public ScreenshotBase(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void tearDown(ITestResult iTestResult) throws IOException {
	    if (iTestResult.FAILURE == iTestResult.getStatus()) {
	        takeScreenshot(iTestResult.getName());
	    }
	}
	public String takeScreenshot(String name) throws IOException {
		
		/*Step 1) Convert web driver object to TakesScreenshot
	      Step 2) Call getScreenshotAs method to create image file
	      Step 3) Copy file to Desired Location*/
		
	    String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	//Take the screenshot
	    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    
	    String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
	            + ".png";
	   
	    File finalDestination = new File(destination);
	 
	    FileHandler.copy(source, finalDestination);
	    //or FileUtils.copyFile import org.apache.commons.io.FileUtils;
	    return destination;   
	}

}
