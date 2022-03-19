package adminSection.Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import projectBase.Scripts.*;

import org.testng.ITestResult;



public class usrAdminDashboard {

	WebDriver driver;
	UserLoginBase ul;
	ScreenshotBase ssb;
	
@BeforeTest	
public void loginsetup() throws InterruptedException {
//	System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTestingICTAK\\Selenium\\CommonFiles\\chromedriver.exe");
//	FirefoxOptions options = new FirefoxOptions();  
//	options.setHeadless(false);
//	WebDriver driver = new FirefoxDriver(options);
//	driver.get("http://64.227.132.109/");
//	driver.manage().window().maximize();
		
		
		ul= new UserLoginBase(driver);
		driver=ul.login();
		
		
}
@Test(priority=1)
public void Dashboard() throws InterruptedException{
//	driver.getPageSource().contains("Dashboard");
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement dashB;
	dashB= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".font-weight-bolder")));
	
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(8000);

}
@Test(priority=2)
public void addTask() throws InterruptedException {
//	Thread.sleep(2000);
	WebElement addTaskText = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/body/main"
			+ "/div[2]/div/div[2]/div/app-todos/div/form/div[1]/div/input"));
//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	addTaskText.click();
	addTaskText.sendKeys("123456");
	driver.findElement(By.cssSelector(".fa-plus")).click();
	 Thread.sleep(2000);
}
	
	
	
@Test(priority=3)
public void pieChartVisiblity() throws InterruptedException {
//	Thread.sleep(2000);
//	String expectedBanner ="ICT LIVE STATUS";
//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement pieChart= driver.findElement(By.id("myChart"));
    Dimension size = pieChart.getSize();
    System.out.println("pieChartBoxSize= "+size.width);
    int actualsize = size.width;
    int expectedsize=400;
    Assert.assertEquals(actualsize, expectedsize);
   
}


@AfterMethod
public void screenshot(ITestResult iTestResult) throws IOException {
	   //Takes screenshot of errors
//	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
ssb=new ScreenshotBase(driver);
ssb.tearDown(iTestResult);

}
@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(10000);
    driver.quit();
}

}
