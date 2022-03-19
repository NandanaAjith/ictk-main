package adminSection.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import projectBase.Scripts.AdminLoginBase;

public class SprAdminKnowledge {
WebDriver driver;
	
	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
	}


@Test(priority=1)
public void courses() throws InterruptedException {
driver.getPageSource().contains("Dashboard");

WebDriverWait wait=new WebDriverWait(driver, 10);

WebElement knowledgebtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(9) > a"));
wait.until(ExpectedConditions.elementToBeClickable(knowledgebtn));
knowledgebtn.click();
Thread.sleep(2000);

//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
}


@Test(priority=2)
public void search() {
	String keyword="12";
	driver.findElement(By.id("listSearch")).sendKeys(keyword);
	String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
	
	if(searchResult.contains(keyword))
      	System.out.println("The search result contains the keyword --- "+searchResult);
	else
      	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}
@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(15000);
    driver.quit();
}


}
