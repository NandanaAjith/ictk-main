package adminSection.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

public class SprAdminEvent {
	WebDriver driver;
	@BeforeTest	
	public void loginsetup() {
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		TestNG testNG = new TestNG();
//		testNG.setUseDefaultListeners(false);
		
}
	@Test(priority=1)
	public void courses() throws InterruptedException {
//	driver.getPageSource().contains("Dashboard");
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	
	
	WebElement evntbtn = driver.findElement(By.xpath("//a[@routerlink='/adminpage/events']"));
	wait.until(ExpectedConditions.elementToBeClickable(evntbtn));
	evntbtn.click();
//	driver.wait(2000);
//	Thread.sleep(2000);
		
	}
	
	
	@Test(priority=2)
	public void search() {
		String keyword="Robotic Process Automation";
		driver.findElement(By.id("listSearch")).sendKeys(keyword);
		String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
		
		if(searchResult.contains(keyword))
          	System.out.println("The search result contains the keyword --- "+searchResult);
    	else
          	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
	@Test(priority=3)
	public void addEvent() throws IOException {
	String EventName = ExcelUtility.getCourseCellData(1, 0);
	String CourseName = ExcelUtility.getCourseCellData(1, 1);
	String CourseType = ExcelUtility.getCourseCellData(1, 2);
	String About = ExcelUtility.getCourseCellData(1, 3);
	String Eventoverview = ExcelUtility.getCourseCellData(1, 4);
	String EventAgenta = ExcelUtility.getCourseCellData(1, 5);
	String EventTraining = ExcelUtility.getCourseCellData(1, 6);
	String EventFee = ExcelUtility.getCourseCellData(1, 7);
	String LastDateofRegistration = ExcelUtility.getCourseCellData(1, 8);
	String EventObjective = ExcelUtility.getCourseCellData(1, 9);
	String RegistrationStatus = ExcelUtility.getCourseCellData(1, 10);

	
	driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
	driver.findElement(By.cssSelector("div.input-box:nth-child(1) > input:nth-child(2)")).sendKeys(EventName);
	driver.findElement(By.cssSelector("div.input-box:nth-child(2) > input:nth-child(2)")).sendKeys(CourseName);
	driver.findElement(By.cssSelector("div.input-box:nth-child(3) > input:nth-child(2)")).sendKeys(CourseType);
	driver.findElement(By.xpath("//*[@id=\"richtexteditor_1057282398_0_rte-edit-view\"]")).sendKeys(About);

	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys(Eventoverview);
	

	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys(EventFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys(EventFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys(EventFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(13) > input")).sendKeys(EventObjective);
	driver.findElement(By.cssSelector("div.input-box:nth-child(14) > input")).sendKeys(EventAgenta);
	driver.findElement(By.id("richtexteditor_2023600528_2_rte-edit-view")).sendKeys(EventTraining);
	driver.findElement(By.cssSelector("div.input-box:nth-child(16) > input")).sendKeys(EventFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(17) > input")).sendKeys(LastDateofRegistration);
	driver.findElement(By.cssSelector("div.input-box:nth-child(18) > input")).sendKeys(EventObjective);
	


//    driver.findElement(By.cssSelector("#flexSwitchCheckDefault")).click();
    
	//code to click add course btn is not added
    driver.findElement(By.cssSelector(".btn.bg-gradient-primary")).click();
    
}
	
	
}
