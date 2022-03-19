package userScenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import projectBase.Scripts.TestBase;

public class JarvisTest {
WebDriver driver;
	
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(5000);
		WebElement testimonialCard = driver.findElement(By.cssSelector("div.owl-item:nth-child(46) > div:nth-child(1) > div"));
		boolean t=testimonialCard.isDisplayed();
		System.out.println(t);
		String card= testimonialCard.getText();
		System.out.println(card);
//		WebElement test1= driver.findElement(By.cssSelector("div.owl-item:nth-child(18) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h4"));
//		String test2= test1.getText();
//		System.out.println(test2);
	}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}
}
