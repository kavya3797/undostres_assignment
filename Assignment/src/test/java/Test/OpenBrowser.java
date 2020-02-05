package Test;

import java.awt.AWTException;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OpenBrowser {
	
	public WebDriver driver;
	//public static ChromeDriver driver;
	//SelectingDriver obj=new SelectingDriver();
	//int ip=SelectionOfDriver.reading();
	@BeforeClass
	public  void setUP() throws Exception
	{
		//if(ip==1) {
		/*System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();*/
		//System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Assignment\\driver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));

        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
		
				
				
		
}	
	
	
	@Test
	public void execute() throws InterruptedException, AWTException {
		
			 TestCases obj = new TestCases();
		        obj.SeleniumTestCases(driver);
		 	
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}



}
