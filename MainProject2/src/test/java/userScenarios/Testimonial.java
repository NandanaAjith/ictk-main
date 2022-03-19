package userScenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import projectBase.Scripts.ExcelUtility;
import projectBase.Scripts.TestBase;

public class Testimonial {
	WebDriver driver;
	
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}
	
	
	@Test
	public void verifyData() throws IOException, InterruptedException {
	String name=ExcelUtility.getTestimonialCellData(1, 0);
	String organisation=ExcelUtility.getTestimonialCellData(1, 1);
	String testimonial=ExcelUtility.getTestimonialCellData(1, 2);
	String CourseTitle=ExcelUtility.getTestimonialCellData(1, 3);
	
	
//	driver.findElement(By.cssSelector("owl-stage.ng-tns-c96-0 > div")).getText();
	
//	WebElement element = driver.findElement(By.cssSelector("div.owl-item:nth-child(47) > div:nth-child(1) > div"));
//	Actions actions = new Actions(driver);
//	actions.moveToElement(element);
//	actions.perform();
	WebDriverWait wait=new WebDriverWait(driver, 10);
//	WebElement testimonialCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.owl-item:nth-child(47) > div:nth-child(1) >"
//			+ " div:nth-child(1) > div")));
	Thread.sleep(4000);
	WebElement testimonialCard = driver.findElement(By.cssSelector("div.owl-item:nth-child(46) > div:nth-child(1) > div"));
	boolean t=testimonialCard.isDisplayed();
	System.out.println(t);
//	int i=1;
//	do {
//	if(testimonialCard.isDisplayed()) {
//		String cardData=testimonialCard.getText();
//		System.out.println(cardData);
//	}
//	else {
		
//	}
//	}
	while(t=false);	{
		WebElement element = driver.findElement(By.cssSelector(".pt-6 > owl-carousel-o:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > i"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);	
	}
	System.out.println(t);
	String cardData=testimonialCard.getText();
	System.out.println(cardData);
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}
}
