package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	@Test
	public void twoTest() throws IOException, InterruptedException {
		System.out.println("inside test Two");
		
		WebDriver driver = initializeDriver();
		driver.get("http://www.tutorialsninja.com/demo/"); 
		Thread.sleep(2000);
		driver.close();
		
	}

}
