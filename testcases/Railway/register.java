package Railway;

import static org.testng.Assert.assertEquals;

import java.awt.Container;

import org.testng.annotations.Test;

public class register extends test {

	@Test
	public void TC07  () {
		System.out.println("User can't create account with an already in-use email");
		System.out.println("Pre-condition: a not-active account is existing");
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.gotoRegiser();
		Register register = new Register();
		register.registor("minhtri4724@gmail.com  ", "" , "1312323123");	
		System.out.println("1. Navigate to QA Railway Website");
		System.out.println("2. Click on \"Login\" tab");
		homePage.gotoLoginPage();

		System.out.println("3. Enter username and password of account hasn't been activated.");
		System.out.println("4. Click on \"Login\" button");
		LoginPage loginPage = new LoginPage();
		loginPage.login("minh13gmail.com", "122324234");
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "Invalid username or password. Please try again.";
	}
}
