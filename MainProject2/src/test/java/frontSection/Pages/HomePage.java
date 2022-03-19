package frontSection.Pages;
//import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;

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


public class HomePage {
	
		private WebDriver driver;
		
		TestBase tb;
		
		@BeforeTest
		public void browserSetup() {
			tb = new TestBase(driver);
			driver=tb.onSetup();
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException 
		{
			//Thread.sleep(5000);
			//driver.close();
		}	

	@Test
		public void _getStartedButton() throws InterruptedException 
	{
			//browserSetup();
			//Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > header > div > div > div > div > div > button")));
			driver.findElement(By.cssSelector("body > header > div > div > div > div > div > button")).click();
			Thread.sleep(2000);


			
}
			
	  @Test 
	  public void _testLeftandRightScrollbar() throws InterruptedException 
	  {
	 
	  JavascriptExecutor jsx=(JavascriptExecutor)driver; 
	  jsx.executeScript("window.scrollBy(0,1500)", "");
	  Thread.sleep(2000); 
	  driver.findElement(By.cssSelector("#carouselExampleControls > div.min-vh-75.position-absolute.w-100.top-0 > a.carousel-control-next > span.carousel-control-next-icon.position-absolute.bottom-50.me-n7"
	  )).click(); 
	  Thread.sleep(2000); 
	  jsx.executeScript("window.scrollBy(0,900)", ""); 
	  Thread.sleep(2000); 
	  driver.findElement(By.xpath("/html/body/app-root/app-home-main/app-cards/body/div/div/owl-carousel-o/div/div[2]/div[2]/i"
	  )).click(); 
	  Thread.sleep(2000);
	  //Actions actions = new Actions(driver);
	  //actions.moveToElement(driver.findElement(By.className("mb-0"))).pause(2000).click(driver.findElement(By.xpath(
	//  "/html/body/app-root/app-home-main/app-cards/body/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[6]/div/div/div/div[2]/div/a/button"))).build().perform(); 
	  //Thread.sleep(2000); 
	  }
	  
	  
	  
	  
	  }
	  
	  
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


