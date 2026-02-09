package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Account.Account;
import Common.Utilities;
import Constant.Constant;
import Menu.MenuRailway;

@Test
public class Register extends BaseTest {

//	public void TC07() {
//		System.out.println("TC07: User can't create account with an already in-use email" +
//					"\nPre-condition: an actived account is existing");
//		Account account = Account.generalAccount();
//		Guerrillamail guerrillamail = new Guerrillamail();
//		guerrillamail.open();
//		guerrillamail.setGuerrillaMail(account.getEmail());
//		String mail = guerrillamail.getGmail();
//		account.setEmail(mail);
//		
//		
//		System.out.println("1. Navigate to QA Railway Website");
//		HomePage homePage = new HomePage();
//		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
//		Utilities.getUrl(Constant.RAILWAY_ULR);
//
//		System.out.println("Click on \"Register\" tab\nEnter information of the created account in Pre-condition"+
//					"\nClick on \"Register\" button");
//		MenuRailway menuRailway = MenuRailway.REGISTER;
//		
//		System.out.println("2. Click on \"Register\" tab");
//		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(menuRailway);
//		registerPage.register(account);
//		
//		System.out.println("3. Enter information of the created account in Pre-condition");
//		WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
//		Utilities.refreshWindow();
//		String linkActiveString = guerrillamail.getLinkActive();
//		
//		System.out.println("4. Click on \"Register\" button");
//		WindowManager.switchToTab(Constant.WINDOW_TAB_RAILWAY);
//		Constant.WEBDRIVER.get(linkActiveString);
//		
//		menuRailway = menuRailway.REGISTER;
//		registerPage = (RegisterPage) homePage.navigateMenu(menuRailway);
//		registerPage.registerByAccount(account);
//		
//		System.out.println("Error message \"This email address is already in use.\" displays above the form.");
//		
//		String actualMessageString = registerPage.getErrorMessage();
//		String expectedMessageString = Constant.REGISTER_MESSAGE_ERROR_DUPLICAP_MAIL;
//		
//		Assert.assertEquals(actualMessageString.trim(), expectedMessageString.trim());
//	}
	
	@Test
	public void TC08(){
		System.out.println("TC08: User can't create account while password and PID fields are empty");
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
		Utilities.getUrl(Constant.RAILWAY_ULR);
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		
		System.out.println("3. Enter valid email address and leave other fields empty");
		System.out.println("4. Click on \"Register\" button");
		
		System.out.println("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
		
		System.out.println("Next to password fields");
		System.out.println("Verify: That error message \"Invalid password length.\" displays");
		
		System.out.println("Next to PID field");
		System.out.println("Verify: That error message \"Invalid ID length.\" displayed");
		Account account = new Account(Constant.USERNAME);
		registerPage.registerByAccount(account);
	}
}
