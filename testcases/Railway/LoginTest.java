package Railway;

import Constant.Constant;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import Common.Utilites;
//đổi test->tétpages
public class LoginTest extends test {
	
	@Test
	public void TC01() {
		System.out.println("TC01: User can log into Railway with valid username and password");
//1. Navigate to QA Railway Website
		
		HomePage homePage = new HomePage();			
		homePage.open();
		
//		2. Click on "Login" tab
//		3. Enter valid Email and Password
//		4. Click on "Login" button
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME , Constant.PASSWORD ).getWelcomeMesssage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
	
		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Welcome message is not displayed as expected");
	}
	//trình bày cách
	@Test
	public void TC02() {
		System.out.print("TC02: User cannot login with blank \"Username\" textbox");
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
		System.out.print("TC03: User cannot log into Railway with invalid password ");
//		1. Navigate to QA Railway Web site
		HomePage homePage = new HomePage();
		homePage.open();
//		2. Click on "Login" tab
		LoginPage loginPage = homePage.gotoLoginPage();
//		3. Enter valid Email and invalid Password
//		4. Click on "Login" button
		loginPage.login("dadasd", Constant.PASSWORD);
		
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC04() {
		System.out.print("TC04: System shows message when user enters wrong password many times");
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
			loginPage.login(Constant.INVALIDUSERNAME, Constant.PASSWORD);
		}
		actualMsg = loginPage.getErrorMessage();
		Assert.assertEquals(actualMsg.trim(), expectedMsg2, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC05() {
		System.out.println("TC05: User can't login with an account hasn't been activated");
		System.out.println("Pre-condition: a not-active account is existing");
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.gotoRegiser();
		Register register = new Register();
		register.registor("minh13gmail.com", "122324234", "1312323123");	
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoLoginPage();

		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		LoginPage loginPage = new LoginPage();
		loginPage.login("minh13gmail.com", con);
		
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "Invalid username or password. Please try again.";
		assertEquals(actualMsg.trim(), expectedMsg, "User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
	}
	
	@Test
	public void TC06() {
		System.out.println("TC06: User is redirected to Home page after logging out");
//		System.out.println("");
		HomePage homePage = new HomePage();
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		System.out.println("2. Login with valid Email and Password");
		homePage.gotoLoginPage();
		LoginPage loginPage = new LoginPage();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		System.out.println("3. Click on \"FAQ\" tab.");
		homePage.gotoFAQ();
		System.out.println("4. Click on \"Log out\" tab");
		homePage.clickLogout();
		System.out.println("Home page displays\"Log out\" tab is disappeared.");
		boolean flag = homePage.isLogoutTabisDisplayed();
		assertEquals(flag, false, "Home page displays\"Log out\" tab is disappeared.");
	}
}
