package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TestCases {
	
	public void SeleniumTestCases(WebDriver driver) throws InterruptedException
	{
		//to navigate to the given URL
		driver.get(" http://prueba.undostres.com.mx ");
		//click on operator field
		WebElement operator= driver.findElement(By.cssSelector("#col-sm-12 > form > div > div:nth-child(1) > div.user-interact > div.form > ul > li:nth-child(1) > div > div"));
		operator.click();
		//WebElement list= driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/div"));
		//list.click();
		//select operator as telecel
		WebElement list= driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/div/ul/li[1]"));
		list.click();
		//Give this number 5523261151 under numero de celluar field and click
		driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[2]/div/div/input")).sendKeys("5523261151");
        driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div")).click();
        Thread.sleep(4000);
        //click on siguiente
        driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div/div/ul[1]/li[1]")).click();
        Thread.sleep(4000);
        //On payment screen click on tarjeta
        driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[3]/div/button")).click();
        //Thread.sleep(8000);
        
        // to verify user reached to payment screen
        /*String expectedUrl = "https://prueba.undostres.com.mx/payment.php";
        String currentUrl= driver.getCurrentUrl();
        if(expectedUrl==currentUrl)
        	System.out.println("user navigated to payment screen");
        */
        
        //enter the following details under card name:Test ,Card number:4111111111111111 ,month=11,date=2025,cvv=111
        driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div[1]/div/div/input")).sendKeys("Test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div[2]/div/div/div[1]/input")).sendKeys("4111111111111111");
		driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div[3]/div[1]/div/div[1]/input")).sendKeys("11");
		driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div[3]/div[1]/div/div[2]/input")).sendKeys("2025");
		driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div[3]/div[2]/div/input")).sendKeys("111");
		Thread.sleep(4000);
		//under correo electronico field give email id as test@test.com.
		driver.findElement(By.xpath("//*[@id=\"email_block\"]/div/div/input")).sendKeys("test@test.com");
		Thread.sleep(4000);
		//Click on pagar con tarjeta to do the recharge 
		driver.findElement(By.xpath("//*[@id=\"paylimit\"]")).click();
		Thread.sleep(4000);
		//A popup will appear ,Enter the following email  marze.zr@gmail.com  and password 123456

		driver.findElement(By.xpath("//*[@id=\"usrname\"]")).sendKeys("marze.zr@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"psw\"]")).sendKeys("123456");
         //To verify captcha
	     // to handle focus from parent to child  
		 String winHandleBefore = driver.getWindowHandle();
		
		 // switching the frame by ID
		 driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td/div/div[1]/form/div[4]/div/div/iframe")));
		 driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span")).click();
		
	
         //to switch control from child window to parent window
		 driver.switchTo().window(winHandleBefore);
		 
		 //form submission to verify recharge request
		 driver.findElement(By.id("loginForm")).submit();
		 Thread.sleep(4000);
		 
		 //to verify recharge submission is successful
		 String actualtext="Recarga Saldo de Telcel al número 5523261151";
		 
		 String  textonEle=driver.findElement(By.xpath("//*[@id=\"mainBlueContainer\"]/div/div[1]/div[1]/div/div/div/div[1]/div[2]/div[1]/span")).getText();
		 try{        
		        Assert.assertEquals(actualtext, textonEle);            
		    }catch(AssertionError e){           
		         System.out.print("recharge failed");  
		    }     
       
	}
	



}
