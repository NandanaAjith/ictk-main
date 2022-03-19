package projectBase.Scripts;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AdminLoginBase {
	WebDriver driver;

@BeforeTest
	public void browserSetup(){
	TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}

@Test
	public WebDriver login(){
		browserSetup();
	
	String username= "superadmin";
	String password= "12345";
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	WebElement loginbtn=driver.findElement(By.cssSelector("a.btn"));
	wait.until(ExpectedConditions.visibilityOf(loginbtn));
	loginbtn.click();
	
	WebElement usrname= driver.findElement(By.cssSelector("div.input-group:nth-child(1) > input"));
	wait.until(ExpectedConditions.visibilityOf(usrname));
	usrname.sendKeys(username);
	driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input:nth-child(2)")).sendKeys(password);
	System.out.println("USERNAME: " +username + " And PASSWORD: " + password);
	driver.findElement(By.cssSelector("button.bg-gradient-info:nth-child(1)")).click();
	
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(driver.findElement(By.cssSelector(".font-weight-bolder")) != null) {
	System.out.println("........Login Successfull........");
	}
	else {
		System.out.println("........Login FAILED........");}
	return driver;
	
}
public AdminLoginBase(WebDriver driver) {
	this.driver=driver;
	}


//@AfterTest
//public void quitBrowser() throws InterruptedException {
//	Thread.sleep(10000);
//    driver.quit();
//}
}
