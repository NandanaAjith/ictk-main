package frontSection.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

public class AcademicMem {
	 private WebDriver driver;
	 TestBase tb;
	 
	 @BeforeTest
		public void browserSetup() {
			tb = new TestBase(driver);
			driver=tb.onSetup();
//			driver.get("http://64.227.132.109/LandingPage");
			driver.findElement(By.id("dropdownMenuDocs")).click();
			 
		}
	 
	@AfterTest
		public void closeBrowser() {
			driver.close();
		}
	 private void viewPage() {
     driver.findElement(By.id("dropdownMenuDocs")).click();
        driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a")).click();

	 }

	// @Test(priority = 1)
	 public void academic() {
		 viewPage();
		 //driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a > span")).click();
	 }
	
         
    @Test(priority=1)
	 public void viewMem() throws InterruptedException {
                 viewPage();
		 		JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)", "");
			WebDriverWait wait = new WebDriverWait(driver, 5000);
		    WebElement webx = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about-section > div.container > div > div.col-lg-5.col-md-5.about-right.aos-init.aos-animate > a")));
		    webx.click();
			//driver.findElement(By.cssSelector("#about-section > div.container > div > div.col-lg-5.col-md-5.about-right.aos-init.aos-animate > a")).click();
//			 
}
		 
     @Test(priority=2)
	 public void scroll() throws InterruptedException {
		 viewPage();
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)", "");
		 WebDriverWait wait = new WebDriverWait(driver, 5000);
		    WebElement webx = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about-section > div.container > div > div.col-lg-5.col-md-5.about-right.aos-init.aos-animate > a")));
		    webx.click();
	 
		// checking the horizontal scroll inside a web element
					WebElement scrollArea = driver.findElement(By.cssSelector("#feature-section > div > div > div > div > div > div"));
					Thread.sleep(2000);

					// Scroll to div's most right:
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
					Thread.sleep(2000);

					// Or scroll the div by pixel number:
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", scrollArea);

	 }
	@Test(priority=3)
	 public void webLinks() throws InterruptedException {
		 viewPage();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)", "");
			 WebDriverWait wait = new WebDriverWait(driver, 5000);
			    WebElement webx = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about-section > div.container > div > div.col-lg-5.col-md-5.about-right.aos-init.aos-animate > a")));
		    webx.click();
		    JavascriptExecutor js21 = (JavascriptExecutor) driver;
			js21.executeScript("window.scrollBy(0,500)", "");
	 WebDriverWait wait1 = new WebDriverWait(driver, 5000);
	WebElement web2 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#feature-section > div > div > div > div > div > div > table > tbody > tr:nth-child(1) > td.align-middle.text-center > div > a")));
	//Thread.sleep(3000);
	web2.click();
	    //driver.findElement(By.cssSelector("#feature-section > div > div > div > div > div > div > table > tbody > tr:nth-child(1) > td.align-middle.text-center > div > a")).click();
	 }
	 
}