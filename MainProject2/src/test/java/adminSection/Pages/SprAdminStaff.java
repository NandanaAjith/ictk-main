package adminSection.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

public class SprAdminStaff {
	WebDriver driver;
	
@BeforeTest	
	public void loginsetup() {
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
 }


@Test(priority=1)
		public void courses() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		WebElement staffbtn = driver.findElement(By.xpath("//a[@routerlink='/adminpage/staffs']"));
		wait.until(ExpectedConditions.elementToBeClickable(staffbtn));
		staffbtn.click();
		
//	driver.wait(2000);
	Thread.sleep(2000);
			
}

@Test(priority=2)
public void search() {
	String keyword="Riji N. Das";
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
public void Adminstaff() throws IOException {
String StaffName = ExcelUtility.getCourseCellData(1, 0);
String About = ExcelUtility.getCourseCellData(1, 1);
String Image = ExcelUtility.getCourseCellData(1, 2);
String Destination = ExcelUtility.getCourseCellData(1, 3);

//driver.setFileDetector(new LocalFileDetector());
File StaffImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "Admin.jpg");
Utils.log("file exists: " + StaffImage.exists());

driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
driver.findElement(By.cssSelector("div.input-box:nth-child(1) > input")).sendKeys(StaffName);


Select DestinationDrop= new Select(driver.findElement(By.cssSelector(".form-select")));
DestinationDrop.selectByVisibleText(Destination);


driver.findElement(By.cssSelector("div.input-box:nth-child(2) > input")).sendKeys(About);
driver.findElement(By.cssSelector("div.input-box:nth-child(3) > input")).sendKeys(Image);

//code to click add course btn is not added
driver.findElement(By.cssSelector(".btn.bg-gradient-primary")).click();

String StaffimagePath = StaffImage.getAbsolutePath();
WebElement input = driver.findElement(By.cssSelector("div.input-group:nth-child(8) > input:nth-child(1)"));
input.sendKeys(StaffimagePath);


//code to click add course btn is not added
driver.findElement(By.cssSelector("button.ms-auto")).click();
}






@AfterTest
public void closeBrowser() {
		driver.close();
	}
 
}
