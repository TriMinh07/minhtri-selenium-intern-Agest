package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Account.Account;
import Constant.Constant;
import Menu.MenuRailway;

public class LogoutTest extends GeneralPage {

	@Test
	public void TC06() {
		System.out.println("TC06: User is redirected to Home page after logging out");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME , Constant.PASSWORD);

		Boolean expectedFlag = false;
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with valid Email and Password");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("3. Click on \"FAQ\" tab.");
		FAQPage faqPage = (FAQPage) homePage.navigateMenu(MenuRailway.FAQ);
		
		System.out.println("4. Click on \"Log out\" tab.");
		LogoutPage logOutPages =  (LogoutPage) homePage.navigateMenu(MenuRailway.LOGOUT);
		
		System.out.println("Verify: That home page displays\"Log out\" tab is disappeared.");
		boolean flag = logOutPages.isLogoutBtnDisplayed();
		
		assertEquals(flag, expectedFlag, "Home page dis plays\"Log out\" tab is disappeared.");
	}
	
}
