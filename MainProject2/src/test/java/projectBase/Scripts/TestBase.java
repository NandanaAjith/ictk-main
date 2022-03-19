package projectBase.Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
	public WebDriver driver;
    public static Properties prop = null;
    String driverPath1;
    String driverPath2;


public static void TestConfig() {
	try {
    	//Below line creates an object of Properties called 'prop'
        prop = new Properties();
      //Below line creates an object of FileInputStream called 'ip'. 
      //Give the path of the properties file which you have created
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                + "/config.properties");
        //Below line of code will load the property file
        prop.load(ip);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

@Parameters("browser")
@BeforeTest
public WebDriver onSetup() {
    TestConfig(); // for loading the configurations
    String browserName = prop.getProperty("browser");
    driverPath1=System.getProperty("user.dir")+"\\CommonFiles\\chromedriver.exe";
    driverPath2=System.getProperty("user.dir")+"\\CommonFiles\\geckodriver.exe";

    if (browserName.equals("chrome")) {
    	System.setProperty("webdriver.chrome.driver", driverPath1);
    	// for faster loading of pages
//    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--start-maximized");
//    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//    	capabilities.setCapability("pageLoadStrategy", "none");
    	driver = new ChromeDriver();
    	

    }
    else if (browserName.equals("firefox")) {
    	//geckodriver
    	System.setProperty("webdriver.gecko.driver", driverPath2);
        driver = new FirefoxDriver();
        
    }
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
//    try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
    return driver;
}
public TestBase(WebDriver driver) {
	this.driver=driver;
}

}



