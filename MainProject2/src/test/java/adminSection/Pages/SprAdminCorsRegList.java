package adminSection.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import pageFactory.pages.CourseRegList;
import projectBase.Scripts.AdminLoginBase;


public class SprAdminCorsRegList {
	CourseRegList objCRL;
	WebDriver driver;
	
	@Test(priority=1, enabled = true)
    public void courseRegList() throws IOException {
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //Create CourseRegList Page object
    objCRL = new CourseRegList(driver);
    // Admin section student course reg list

    objCRL.CourseRegBtn();
    objCRL.dwnldBtn();
	}
	
    @Test(priority=2, enabled= true)
    public void userDel() throws InterruptedException{
 
    	WebElement studentnameBox=driver.findElement(By.cssSelector("tbody.ng-star-inserted:nth-child(2) > tr"));
    	String studentname=studentnameBox.getText();
    	System.out.println(studentname);
    	
    	String actualStudentname="abc";
    	if(studentname.contains(actualStudentname)) {
    		objCRL.UserRegDelete();
    		objCRL.confirmDelete();
    	}
    	else {
    		System.out.println("Cannot find studentname from list");
    	}
    
    
    }
    @AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}
}
