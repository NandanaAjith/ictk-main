package frontSection.Pages;
import java.util.ArrayList;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutUs {
	
		private WebDriver driver;
		TestBase tb;
		
		@BeforeTest
		public void browserSetup() {
			tb = new TestBase(driver);
			driver=tb.onSetup();
		}
		
//		@AfterTest
//		public void closeBrowser() throws InterruptedException {
//			Thread.sleep(10000);
//			driver.quit();
//		}
//		

	@Test
		public void _testKnowMoreButton() throws InterruptedException {
		//browserSetup();
		driver.get("http://64.227.132.109/LandingPage/about");
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,5450)", "");
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.className("fa-play")));
			driver.findElement(By.className("fa-play")).click();
			Thread.sleep(2000);
			
	}

		@Test
		public void testCareersButton() throws InterruptedException {
			driver.get("http://64.227.132.109/LandingPage/about");
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,7500)", "");
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CAREERS")));
			driver.findElement(By.linkText("CAREERS")).click();
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(5000);
			driver.switchTo().window(tabs.get(1)).close();
			
			//driver.switchTo().window(tabs.get(0)).close();
			
		}
		@AfterTest
		public void closeBrowser() throws InterruptedException {
			Thread.sleep(10000);
			driver.quit();
		}
		

	}


