

package Railway;

import Constant.Constant;
import Menu.MenuRailway;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;

import org.testng.annotations.Test;

import Account.Account;
import Constant.Constant;

public class LoginTest extends BaseTest {
	
	@Test
	public void TC01() {
		System.out.println("TC01: User can log into Railway with valid username and password");
		HomePage homePage = new HomePage();		
		Account account = new Account(Constant.USERNAME , Constant.PASSWORD);
		
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		System.out.println("1. Navigate to QA Railway Website");		
		homePage.open();
		System.out.println("2. Click on \"Login\" tab");
		System.out.println("3. Enter valid Email and Password");
		System.out.println("4. Click on \"Login\" button");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		
		System.out.println("User is logged into Railway. Welcome user message is displayed.");

		String actualMsg = loginPage.login(account).getWelcomeMesssage();
	
		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Welcome message is not displayed as expected");
	}

	@Test
	public void TC02() {
		System.out.print("TC02: User cannot login with blank \"Username\" textbox");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME , Constant.INVALID_PASSWORD);
		
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("1. Navigate to QA Railway Web site");
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		
		System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(account);
		
		System.out.println("User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
		String actualMsg = loginPage.getErrorMessage();

 		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC03() {
		System.out.print("TC03: User cannot log into Railway with invalid password ");
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME , Constant.PASSWORD);
		
		System.out.println("1. Navigate to QA Railway Web site");
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		loginPage.login(account);
		
		System.out.println("Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
		String actualMsg = loginPage.getErrorMessage();
		
		Assert.assertEquals(actualMsg.trim(), expectedMsg, "Error message is not displayed as expected");
	}

	@Test 
	public void TC04() {
		System.out.print("TC04: System shows message when user enters wrong password many times");
		HomePage homePage = new HomePage();
		String actualMsg1 = "";
		String actualMsg2 = "";
		String expectedMsg1 = "Invalid username or password. Please try again";
		String expectedMsg2 = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		System.out.println("1. Navigate to QA Railway Web site");
		homePage.open();
		
		System.out.println("2. Click on \"Login\" tab");
		System.out.println("3. Enter valid Email and invalid Password");
		System.out.println("4. Click on \"Login\" button");
		System.out.println("5. Repeat step 3 and 4 three more times");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);

		
		for (int i = 0; i <= 4; i++) {
			Account account = new Account(Constant.USERNAME , Constant.PASSWORD);
			loginPage.login(account);
			if (i == 0) {
				expectedMsg1 = loginPage.getErrorMessage();
			}
		}
		System.out.println("\"Invalid username or password. Please try again\" is shown");
		Assert.assertEquals(actualMsg1, expectedMsg1, "The first error message is displayed.");
		
		System.out.println("Verify: That user can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		
		actualMsg2 = loginPage.getErrorMessage();
		Assert.assertEquals(actualMsg2.trim(), expectedMsg2, "Error message is not displayed as expected");
	}
	
	@Test 
	public void TC05() {
		System.out.println("TC05: User can't login with an account hasn't been activated");
		HomePage homePage = new HomePage();
		RegisterPage register = new RegisterPage();
		Account account = new Account(Constant.INVALID_UERNAME, Constant.PASSWORD);
		
		String expectedMsg = "Invalid username or password. Please try again.";
		
		System.out.println("Pre-condition: a not-active account is existing");
		homePage.open();
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		register.registerByAccount(account);
		
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);

		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("Verify: That user can't login and message \"Invalid username or password. Please try again.\" appears.");
		String actualMsg = loginPage.getErrorMessage();

		assertEquals(actualMsg.trim(), expectedMsg, "User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
	}


}
