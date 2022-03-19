package adminSection.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import projectBase.Scripts.UserLoginBase;

public class usrAdminCourses {
	
	WebDriver driver;
@BeforeTest	
	public void login() throws InterruptedException {
		
		UserLoginBase ul;
		ul= new UserLoginBase(driver);
		driver= ul.login();
		
}
@Test	
	public void courses() throws InterruptedException {
	Thread.sleep(4000);
	driver.getPageSource().contains("Dashboard");
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("/html/body/app-root/app-dashboard/body/aside/app-sidenavbar"
			+ "/aside/div[2]/ul/div/ul/li[2]/a")).click();
		
	
	}


@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(10000);
    driver.quit();
}

}
