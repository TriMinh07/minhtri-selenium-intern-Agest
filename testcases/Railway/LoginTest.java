package Railway;

import Constant.Constant;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	@BeforeMethod 
	public void beforeMethod() {
		System.out.println("Pre-condition");
		Constant.WEBDRIVER = new ChromeDriver();
		
//		Dimension dimention = new Dimension(1400,700);
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		
//		Constant.WEBDRIVER.quit();
	}
	
//	@Test
//	public void TC01() {
//		System.out.println("TC01 - User can log into Railway with valid username and password");
////1. Navigate to QA Railway Website
//		
//		HomePage homePage = new HomePage();			
//		homePage.open();
//		
////		2. Click on "Login" tab
////		3. Enter valid Email and Password
////		4. Click on "Login" button
//		LoginPage loginPage = homePage.gotoLoginPage();
//		
//		String actualMsg = loginPage.login(Constant.USERNAME , Constant.PASSWORD ).getWelcomeMesssage();
//		String expectedMsg = "Welcome " + Constant.USERNAME;
//	
//		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Welcome message is not displayed as expected");
//	}
	
	@Test
	public void TC02() {
		System.out.print("User cannot login with blank \"Username\" textbox");
//		1. Navigate to QA Railway Web site
		HomePage homePage = new HomePage();
		homePage.open();
//		2. Click on "Login" tab
		LoginPage loginPage = homePage.gotoLoginPage();
//		3. User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox 
//		4. Click on "Login" button
		loginPage.login("", Constant.PASSWORD);
		
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
 		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC03() {
		System.out.print("User cannot log into Railway with invalid password ");
//		1. Navigate to QA Railway Web site
		HomePage homePage = new HomePage();
		homePage.open();
//		2. Click on "Login" tab
		LoginPage loginPage = homePage.gotoLoginPage();
//		3. Enter valid Email and invalid Password
//		4. Click on "Login" button
		loginPage.login("dadasd", "omgggggasas");
		
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		System.out.print("System shows message when user enters wrong password many times");
//		1. Navigate to QA Railway Web site
		HomePage homePage = new HomePage();
		homePage.open();
//		2. Click on "Login" tab
//		3. Enter valid Email and invalid Password
//		4. Click on "Login" button
//		5. Repeat step 3 and 4 three more times
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = "";
		String expectedMsg1 = "Invalid username or password. Please try again";
		String expectedMsg2 = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		for (int i = 0; i <= 4; i++) {
			loginPage.login("dadasd"+i, "omgggggasas");
		}
		actualMsg = loginPage.getErrorMessage();
		Assert.assertEquals(actualMsg.trim(), expectedMsg2, "Error message is not displayed as expected");
		
	}
	
}
