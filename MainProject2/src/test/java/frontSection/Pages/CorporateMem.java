package frontSection.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

public class CorporateMem {
	 private WebDriver driver;
	 TestBase tb;

	 @BeforeTest
	 public void browserSetup() {
		 tb = new TestBase(driver);
		 driver=tb.onSetup();
		 driver.get("http://64.227.132.109/LandingPage");
		 driver.findElement(By.id("dropdownMenuDocs")).click();
			}
//	 
//	 @AfterTest
//	 public void closeBrowser() {
//		 driver.close();
//	 }
	 private void clickmain() throws InterruptedException {
		 driver.findElement(By.cssSelector(" #navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a")).click();	
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector("body > app-root > app-corporate > app-bannercorporate > header > div > div.container > div > div > button")).click();
	 }
	// @Test
	 public void clickCorporate() {
		 driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a > h6")).click();
	 }
	 @Test
	 public void registerHere() throws InterruptedException {
		 clickmain();
			
			// filling the corporate form
			driver.findElement(By.name("name")).sendKeys("Anjali");
			driver.findElement(By.name("address")).sendKeys("Gayathri nagar banglore");
			driver.findElement(By.name("head")).sendKeys("Chief product officer");
			driver.findElement(By.name("nature")).sendKeys("Products");
			driver.findElement(By.name("website")).sendKeys("www.nytimes.com");
			driver.findElement(By.name("identityNo")).sendKeys("HT45567KKOY89");
			driver.findElement(By.name("GST")).sendKeys("22");
			driver.findElement(By.cssSelector(
					"body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(5) > div:nth-child(2) > div > input"))
					.sendKeys("G6384HJK");
			driver.findElement(By.name("GST")).sendKeys("22");

			// verifying point of contact form
			driver.findElement(By.name("nameofContact")).sendKeys("Deepthi");
			driver.findElement(By.cssSelector(
					"body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(8) > div:nth-child(2) > div > input"))
					.sendKeys("7483798093");
			driver.findElement(By.name("TechnicalSkill")).sendKeys("Java,SQL");
			driver.findElement(By.cssSelector("body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(10) > div:nth-child(1) > div > input")).sendKeys("deeothi123@gmail.com");;
			driver.findElement(By.name("employeeCount")).sendKeys("150");
			driver.findElement(By.name("details")).sendKeys("Bravo");
						//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,150)", "");
//		 WebDriverWait wait1 = new WebDriverWait(driver, 5000);
//		WebElement element9 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='REGISTER']")));
//	    element9.click();

			//driver.findElement(By.xpath("//input[@value='REGISTER']")).click();
			//Thread.sleep(3000);
			// verifying alert
//					Alert alert = driver.switchTo().alert();
//					System.out.println(alert.getText());
//					alert.accept(); // click on ok button
					//driver.navigate().back();


	 }
	 
	 @AfterTest
	 public void closeBrowser() {
		 driver.close();
	 }
}
