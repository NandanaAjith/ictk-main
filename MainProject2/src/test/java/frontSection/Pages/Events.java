package frontSection.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

public class Events {
	private WebDriver driver;
	TestBase tb;

	@BeforeTest
	public void browserSetup() {
		tb = new TestBase(driver);
		driver = tb.onSetup();
		driver.get("http://64.227.132.109/LandingPage");
		//selectEvents();

	}

	private void selectEvents() {
		//driver.findElement(By.id("dropdownMenuDocs")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home-main[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")).click();
	}

	private void selectSalesforce() {
		selectEvents();
		driver.findElement(By.cssSelector(
				"#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a")).click();

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,100)", "");
	}
	private void roboticProcess() {
		selectEvents();
		driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a > h6")).click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test(priority = 1)
	public void about() {
		selectSalesforce();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-home-tab")));
		element.click();

	}

	@Test(priority = 2)
	public void objectives()  {
		//selectSalesforce();
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-profile-tab > i")));
////		//Thread.sleep(2000);
element1.click();
		//driver.findElement(By.cssSelector("#v-pills-profile-tab")).click();
		//driver.execute_script("arguments[0].click();", WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.CSS_SELECTOR, "#v-pills-profile-tab"))));
	}

	

	@Test(priority = 3)
	public void overview() {
		//selectSalesforce();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)", "");
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-messages-tab")));
		element2.click();
		//driver.findElement(By.cssSelector("#v-pills-messages-tab")).click();
	}

	@Test(priority = 4)
	public void agenda() {
		//JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//js2.executeScript("window.scrollBy(0,800)", "");
		//selectSalesforce();	
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-settings-tab")));
		element3.click();
		//driver.findElement(By.cssSelector("#v-pills-settings-tab")).click();
	}

	@Test(priority = 5)
	public void training() {
		//selectSalesforce();
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-download-tab")));
    element4.click();

		//driver.findElement(By.cssSelector("#v-pills-download-tab")).click();
	}

	@Test(priority = 6)
	public void register() throws InterruptedException {
		roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > header > div.page-header.min-vh-70 > div.container > div > div > button")));
		element5.click();
		driver.findElement(By.name("name")).sendKeys("Priya");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(2) > input"))
				.sendKeys("priya@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(3) > input"))
				.sendKeys("456782987");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div.text-center")).click();
		Thread.sleep(2000);

		Alert al = driver.switchTo().alert();
		// click on OK to accept with accept()
		al.accept();
	}
//	//@Test(priority = 7)
//	public void roboticProcess1() throws InterruptedException {
//		driver.findElement(By.cssSelector("body > header > div.page-header.min-vh-70 > div.container > div > div > button")).click();
//		Thread.sleep(2000);;
//		driver.findElement(By.name("name")).sendKeys("Priya");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(2) > input")).sendKeys("priya@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(3) > input")).sendKeys("456782987");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div.text-center")).click();
//		Thread.sleep(2000);
//	
//		 Alert al = driver.switchTo().alert();
//	      // click on OK to accept with accept()
//	      al.accept();
//	      //driver.quit();
//	}

	@Test(priority = 7)
	public void about1() {
		//roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.id("v-pills-home-tab")));
		element6.click();
		//driver.findElement(By.id("v-pills-home-tab")).click();
	}

	@Test(priority = 8)
	public void object() {
		//roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#v-pills-home-tab")));
		element7.click();
		driver.findElement(By.id("v-pills-profile-tab")).click();
	}

	@Test(priority = 9)
	public void over() {
		//roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element8 = wait.until(ExpectedConditions.elementToBeClickable(By.id("v-pills-messages-tab")));
		element8.click();
		//driver.findElement(By.id("v-pills-messages-tab")).click();
	}

	@Test(priority = 10)
	public void agenda1() {
		//roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element9 = wait.until(ExpectedConditions.elementToBeClickable(By.id("v-pills-settings-tab")));
		element9.click();
		//driver.findElement(By.id("v-pills-settings-tab")).click();
	}

	@Test(priority = 11)
	public void train() {
		//roboticProcess();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(By.id("v-pills-download-tab")));
		elements.click();
		//driver.findElement(By.id("v-pills-download-tab")).click();
	}

	@Test(priority = 12)
	public void access() {
		//roboticProcess();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,900)", "");
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement elementW = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > section.py-lg-7.pb-5 > div.mt-sm-n10.mt-n7 > div > div.tab-content.tab-space > div > div > div > div > div.col-lg-4.my-auto > div > button")));
		elementW.click();
		//driver.findElement(By.cssSelector(
				//"body > div > section.py-lg-7.pb-5 > div.mt-sm-n10.mt-n7 > div > div.tab-content.tab-space > div > div > div > div > div.col-lg-4.my-auto > div > button"))
				//.click();
	}
	

}
