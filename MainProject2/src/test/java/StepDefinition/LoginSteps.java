package StepDefinition;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectBase.Scripts.*;

public class LoginSteps {
	WebDriver driver;
//	TestBase tb;

	@Given("user is navigated to loginpage")
	public void user_is_navigated_to_loginpage() {
//		System.setProperty("webdriver.gecko.driver", "D:\\SoftwareTestingICTAK\\Selenium\\CommonFiles\\geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();  
//		options.setHeadless(false);
//		driver= new FirefoxDriver(options);
//		driver.get("http://64.227.132.109/");
//		driver.manage().window().maximize();
		
		TestBase tb;
		tb = new TestBase(driver);
		driver = tb.onSetup();
		
		
		System.out.println("Inside Step - user is on login page");	
	
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.cssSelector("a.btn")).click();
		System.out.println("clicked successfully");
}

	@Then("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		
		WebElement usrname= driver.findElement(By.cssSelector("div.input-group:nth-child(1) > input:nth-child(2)"));
		usrname.sendKeys(username);
		driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input:nth-child(2)")).sendKeys(password);
		System.out.println("USERNAME: " +username + " And PASSWORD: " + password);
	
		
		System.out.println("Inside Step - enter username and password");
	}
	
	@And("clicks on signin button")
	public void clicks_on_signin_button() {
		
		driver.findElement(By.cssSelector("button.bg-gradient-info:nth-child(1)")).click();

		System.out.println("Inside Steps - clicks on signin button");
	}

	@Then("user is redirected user dashboard")
	public void user_is_redirected_to_the_home_page() throws InterruptedException {
		
		System.out.println("Inside Step - user is navigated to the home page");
		
		if(driver.getPageSource().contains("Dashboard")) {
			
			System.out.println("..........SUCCESSFULLY Logged-in...........");
		
		} else {
			System.out.println("*******FAILED to get text********");
		}
	}
}