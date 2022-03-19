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

public class ContactUs {
	private WebDriver driver;
	TestBase tb;

	@BeforeTest
	public void browserSetup() {
		tb = new TestBase(driver);
		driver = tb.onSetup();
		driver.get("http://64.227.132.109/LandingPage");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home-main[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[6]/a[1]"))
				.click();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

    @Test(priority = 1)
	public void facebookIcon() {
    	WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > header > div > div > div > div > div > a:nth-child(1) > i")));
		element.click();
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void twitterIcon() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fab fa-twitter text-lg text-white me-4']")));
		element1.click();
		driver.navigate().back();
		//driver.findElement(By.xpath("//i[@class='fab fa-twitter text-lg text-white me-4']")).click();
		// driver.navigate().back();
	}

	@Test(priority = 3)
	public void googleplus() {
		driver.findElement(By.cssSelector("body > header > div > div > div > div > div > a:nth-child(4) > i")).click();
		driver.navigate().back();
	}

	@Test(priority = 4)
	public void insta() {
		driver.findElement(By.xpath("//i[@class='fab fa-instagram text-lg text-white me-4']")).click();
		driver.navigate().back();
	}

	@Test(priority = 5)
	public void contactUs() {
		driver.get("http://64.227.132.109/LandingPage");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-home-main[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[6]/a[1]"))
				.click();

	}
// verifying message Form
	@Test(priority = 6)
	public void sendMessage() throws InterruptedException {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Rahul.J");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rahul123@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='What you love']")).sendKeys("Testing");
		driver.findElement(By.id("message")).sendKeys("Excellent");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div[2]/div")).click();
		Thread.sleep(2000);
		// Alert interface and switchTo().alert() method
		Alert al = driver.switchTo().alert();
		// click on OK to accept with accept()
		al.accept();
	}
// verifying email tab
	@Test(priority = 7)
	public void email() throws InterruptedException {		
		driver.findElement(By.cssSelector(
				"body > div > section.my-5.pt-5 > div > div > div.col-md-6.m-auto > div > div.col-8 > div > input"))
				.sendKeys("tania@gmail.com");
		Thread.sleep(2000);
		// verifying subscribe button
		driver.findElement(By.cssSelector(
				"body > div > section.my-5.pt-5 > div > div > div.col-md-6.m-auto > div > div.col-4.ps-0 > button"))
				.click();
	}

}
