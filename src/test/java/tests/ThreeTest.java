package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base
{

	@Test
	public void	threeTest() throws IOException, InterruptedException {
		System.out.println("Inside test three");
		WebDriver driver = initializeDriver();
		driver.get("http://www.tutorialsninja.com/demo/"); 
		Thread.sleep(2000);
		driver.close();

	}

}
