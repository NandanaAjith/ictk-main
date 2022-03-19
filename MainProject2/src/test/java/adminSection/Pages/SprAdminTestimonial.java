package adminSection.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

public class SprAdminTestimonial  {
	//***** To run this class separately Uncomment WebDriver  @BeforeTest @AfterTest*** 
	//and remove extends class
	
WebDriver driver;
	
	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
	}
	@Test(priority=4)
	public void TestimonialTab() {
		driver.getPageSource().contains("Dashboard");

		WebDriverWait wait=new WebDriverWait(driver, 6);
		
		WebElement testimoBtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(3) > a"));
		wait.until(ExpectedConditions.elementToBeClickable(testimoBtn));
		testimoBtn.click();
	}
	@Test(priority=5)
	public void searchByName() throws InterruptedException {
		
	//search by student name
		String keyword1="Jewel";
		driver.findElement(By.id("listSearch")).sendKeys(keyword1);
		String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
		
		if(searchResult.contains(keyword1))
          	System.out.println("*****The search result contains the name**** --- "+searchResult);
    	else
          	System.out.println("*****The search result doesn't contains the name**** --- "+searchResult);
		Thread.sleep(3000);
	}
	@Test(priority=6)
	public void searchByOrg() {
	//search by Organization
		String keyword2="provise";
		WebElement search2= driver.findElement(By.id("listSearch"));
		search2.clear();
		search2.sendKeys(keyword2);
		String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
		
		if(searchResult.contains(keyword2))
	      	System.out.println("*****The search result contains the OrgName**** --- "+searchResult);
		else
	      	System.out.println("*****The search result doesn't contains the OrgName**** --- "+searchResult);
		}

	@Test(priority=7)
	public void NewTestimony() throws IOException {
		String name=ExcelUtility.getTestimonialCellData(1, 0);
		String organisation=ExcelUtility.getTestimonialCellData(1, 1);
		String testimonial=ExcelUtility.getTestimonialCellData(1, 2);
		String CourseTitle=ExcelUtility.getTestimonialCellData(1, 3);
		
		driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input")).sendKeys(name);
		driver.findElement(By.cssSelector("div.input-group:nth-child(4) > input")).sendKeys(organisation);
		driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(testimonial);
		
		Select courseTitle= new Select(driver.findElement(By.cssSelector(".form-select")));
		courseTitle.selectByValue(CourseTitle);
		
		File CourseImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "WWW_YTS_AG.jpg");
	    Utils.log("file exists: " + CourseImage.exists());

	    String CourseimagePath = CourseImage.getAbsolutePath();
	    WebElement input = driver.findElement(By.cssSelector("div.input-group:nth-child(9) > input"));
	    input.sendKeys(CourseimagePath);
	    
	  //code to click add course btn is not added
//	    driver.findElement(By.cssSelector("button.ms-auto")).click();
	}
	
	
	
	
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}




}
