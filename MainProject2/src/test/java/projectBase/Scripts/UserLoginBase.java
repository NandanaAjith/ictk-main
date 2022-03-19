package projectBase.Scripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class UserLoginBase {
	WebDriver driver;
	TestBase tb;

@BeforeTest
	public void browserSetup() {
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}

@Test
	public WebDriver login() throws InterruptedException {
		browserSetup();
	String username= "useradmin";
	String password= "12345";
	
	driver.findElement(By.cssSelector("a.btn")).click();
	Thread.sleep(1000);
	WebElement usrname= driver.findElement(By.cssSelector("div.input-group:nth-child(1) > input:nth-child(2)"));
	usrname.sendKeys(username);
	driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input:nth-child(2)")).sendKeys(password);
	System.out.println("USERNAME: " +username + " And PASSWORD: " + password);
	driver.findElement(By.cssSelector("button.bg-gradient-info:nth-child(1)")).click();
	System.out.println("........Login Successfull........");
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return driver;
	
}
public UserLoginBase(WebDriver driver) {
	this.driver=driver;
	}
}
