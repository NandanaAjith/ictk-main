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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Courses {
	
	
	private WebDriver driver;
	TestBase tb;
	
	@BeforeTest
	public void browserSetup() {
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}


	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void _testCoursesMainButton() throws InterruptedException {
		driver.get("http://64.227.132.109/LandingPage/courses");
		driver.findElement(By.id("listSearch")).sendKeys("Data Science");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.className("card-description"))).pause(2000)
				.click(driver.findElement(By.className("btn-info"))).build().perform();
		Thread.sleep(2000);
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)).close();
		
	}
}
