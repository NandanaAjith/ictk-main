package frontSection.Pages;

import org.openqa.selenium.Alert;
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

public class Partnership {
	 private WebDriver driver;
	 TestBase tb;

	 @BeforeTest
	 public void browserSetup() {
		 tb = new TestBase(driver);
		 driver=tb.onSetup();
//		 driver.get("http://64.227.132.109/LandingPage");
		 //selectPartner();	
		}
	 @Test(priority=1)
	public void selectPartner() {
		driver.findElement(By.id("dropdownMenuDocs")).click();
		driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(3) > a > span")).click();
	}
	 
	 @Test(priority=3)
	 public void registerHere() throws InterruptedException {
//		 selectPartner();
		 driver.findElement(By.cssSelector("body > app-root > app-partnership > app-bannerpartnership > header > div > div.container > div > div > button")).click();
		 //driver.findElement(By.cssSelector("body > app-root > app-partnership > app-bannerpartnership > header > div > div.container > div > div > button")).click();
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)", "");
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teena Mathew");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(
					"body > app-root > app-partenshipform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > div > div.card.card-plain > form > div > div:nth-child(1) > div.col-md-6.ps-md-2 > div > input"))
					.sendKeys("teena@gmail.com");
			driver.findElement(By.name("phone")).sendKeys("7909076655");
			Thread.sleep(2000);
			driver.findElement(By.name("firm")).sendKeys("3-06-2021");
			driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Pazhassi quarters");
			Thread.sleep(2000);
			driver.findElement(By.name("district")).sendKeys("Ernakulam");
			driver.findElement(By.name("officeSpace")).sendKeys("400");
			driver.findElement(By.xpath("//input[@placeholder='Number of Employees']")).sendKeys("600");
			driver.findElement(By.name("report")).sendKeys("Training industry conducts research");
			driver.findElement(By.name("expect")).sendKeys("Utilizing the strength");
			driver.findElement(By.name("profile")).sendKeys("Flexible & Diplomatic");
//			Thread.sleep(3000);
//            JavascriptExecutor js21 = (JavascriptExecutor) driver;
//            js21.executeScript("window.scrollBy(0,200)", "");
//
//		WebDriverWait wait = new WebDriverWait(driver, 5000);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable
//				(By.cssSelector("body > app-root > app-partenshipform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > div > div.card.card-plain > form > div > div:nth-child(8) > div > button")));
//
//		element.click();
//		driver.findElement(By.cssSelector("body > app-root > app-partenshipform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > div > div.card.card-plain > form > div > div:nth-child(8) > div > button")).click();
//		Thread.sleep(3000);
//
//			// verifying alert
//			Alert alert = driver.switchTo().alert();
//			Thread.sleep(3000);
//			//System.out.println(alert.getText());
//			alert.accept(); // click on ok button
//			//driver.navigate().back();
			
	 }
	 @Test(priority=2)
	 public void download() {
//		 selectPartner();
//				 WebDriverWait wait = new WebDriverWait(driver, 5000);
//			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bg-gradient-primary")));
//			element.click();
//	driver.findElement(By.cssSelector(".bg-gradient-primary")).click();
			WebElement element = driver.findElement(By.cssSelector(".bg-gradient-primary"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
	 }
	 @Test(priority=4)
	 public void registerBtn() {
//		 selectPartner();
		 WebElement element = driver.findElement(By.cssSelector(".bg-gradient-primary"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
	 
	 }
	 @AfterTest
	 public void closeBrowser() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.close();
	 }
}
