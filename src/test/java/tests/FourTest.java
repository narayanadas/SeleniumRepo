package tests;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;


public class FourTest extends Base {
	public WebDriver driver;
	
	@Test
	public void fourTest() throws IOException, InterruptedException {
		System.out.println("Inside test four");
		driver = initializeDriver();
		driver.get("http://www.tutorialsninja.com/demo/"); 
		Thread.sleep(2000);
		
		//Assert.assertTrue(false); 
		//this line is written for the listener on test fail
		Assert.assertTrue(true);
	}
	
	public void closer() {
		driver.close();
	}

}
