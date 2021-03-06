package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger logger;
	
	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String exptecteResult) throws IOException {
		
		//logger = LogManager.getLogger();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		logger.debug("Clicked on MyAccount DropDown");
		landingPage.loginOption().click();
		logger.debug("Clicked on Longin Option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		logger.debug("email is entered");
		loginPage.passwordField().sendKeys(password);
		logger.debug("Password is entered");
		loginPage.loginButton().click();
		logger.debug("clicked on login button");
		
		AccountPage accountPage = new AccountPage(driver);
		//Assert.assertTrue(accountPage.editYourAccountInformation().isDisplayed());
		//System.out.println(accountPage.editYourAccountInformation().isDisplayed());
		
		String actualResult = null;
		try {
			if(accountPage.editYourAccountInformation().isDisplayed()) {
				logger.debug("user got logged in");
				actualResult  = "Successful";
			}
						
		}
		catch (Exception e) {
			logger.debug("User doen't get logged in");
			actualResult = "Failure";
		}
		
		Assert.assertEquals(actualResult, exptecteResult);
		logger.info("Login got passed");
	}
	
	@BeforeMethod
	public void openApplicaion() throws IOException {
		logger = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		logger.debug("Bwoser got Launched");
		//driver.get("http://www.tutorialsninja.com/demo/");
		driver.get(prop.getProperty("url"));
		logger.debug("Navigated to Applicaton URL");
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		logger.debug("Browser Got closed");
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"arun.selenium@gmail.com", "Second@123","Successful"},{"dummy@test","dummy@123","Failure"}} ;
	return data;	
	
		
	}

}
