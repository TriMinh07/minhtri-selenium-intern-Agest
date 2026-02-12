package Railway;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import javax.crypto.spec.ChaCha20ParameterSpec;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Account.Account;
import Common.Utilities;
import Constant.Constant;
import Element.RegistorError;
import Menu.MenuRailway;

@Test
public class Register extends BaseTest {

	public void TC07() {
		System.out.println("TC07: User can't create account with an already in-use email" +
					"\nPre-condition: an actived account is existing");
		Account account = Account.generalAccount();
		Guerrillamail guerrillamail = new Guerrillamail();
		guerrillamail.open();
		guerrillamail.setGuerrillaMail(account.getEmail());
		String mail = guerrillamail.getGmail();
		account.setEmail(mail);
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
		Utilities.getUrl(Constant.RAILWAY_ULR);

		System.out.println("Click on \"Register\" tab\nEnter information of the created account in Pre-condition"+
					"\nClick on \"Register\" button");
		MenuRailway menuRailway = MenuRailway.REGISTER;
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(menuRailway);	
		registerPage.registerByAccount(account);
		
		System.out.println("3. Enter information of the created account in Pre-condition");
		WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
		Utilities.refreshWindow();
		String linkActiveString = guerrillamail.getLinkActive();
		
		System.out.println("4. Click on \"Register\" button");
		WindowManager.switchToTab(Constant.WINDOW_TAB_RAILWAY);
		Constant.WEBDRIVER.get(linkActiveString);
		
		menuRailway = menuRailway.REGISTER;
		registerPage = (RegisterPage) homePage.navigateMenu(menuRailway);
		registerPage.registerByAccount(account);
		
		System.out.println("Error message \"This email address is already in use.\" displays above the form.");
		
		String actualMessageString = registerPage.getErrorMessage();
		String expectedMessageString = Constant.REGISTER_MESSAGE_ERROR_DUPLICAP_MAIL;
		
		Assert.assertEquals(actualMessageString.trim(), expectedMessageString.trim());
	}
	
	@Test
	public void TC08 (){
		System.out.println("TC08: User can't create account while password and PID fields are empty");
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		Account account = new Account(Constant.USERNAME);
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		
		System.out.println("3. Enter valid email address and leave other fields empty");
		System.out.println("4. Click on \"Register\" button");
		System.out.println("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
		registerPage.registerByAccount(account);
		
		SoftAssert softAssert = new SoftAssert();
		String expectedRegisterErrMsg = "There're errors in the form. Please correct the errors and try again.";
		String registerErrMsg = registerPage.getErrorMessage();
		softAssert.assertEquals(registerErrMsg.trim(), expectedRegisterErrMsg, "Error message is displayed");
		
		System.out.println("Next to password fields");
		System.out.println("Verify: That error message \"Invalid password length.\" displays");
		String passwordErrMsg = registerPage.getErrorMessageOfField(RegistorError.REGISTER_PASSWORD_ERROR);
		String expectedPassErrMsg = "Invalid password length";

		softAssert.assertEquals(passwordErrMsg.trim(), expectedPassErrMsg, "error message \"Invalid password length.\" displays");
		
		System.out.println("Next to PID field");
		System.out.println("Verify: That error message \"Invalid ID length.\" displayed");
		String pidErrMsg = registerPage.getErrorMessageOfField(RegistorError.REGISTER_PID_ERROR);
		String expectedPidErrMsg = "Invalid ID length";
		softAssert.assertEquals(pidErrMsg.trim(), expectedPidErrMsg, "error message \"Invalid ID length.\" displayed");
		
		softAssert.assertAll();
	}
	
	@Test
	public void TC09 (){
		System.out.println("TC08: User can't create account while password and PID fields are empty");
		System.out.println("1. Navigate to QA Railway Website");
		
		Account account = Account.generalAccount();
		Guerrillamail guerrillamail = new Guerrillamail();
		guerrillamail.open();
		guerrillamail.setGuerrillaMail(account.getEmail());
		String mail = guerrillamail.getGmail();
		account.setEmail(mail);
		account.setPassword(Constant.PASSWORD);
		account.setPid(Constant.PID);
		
		HomePage homePage = new HomePage();
		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
		Utilities.getUrl(Constant.RAILWAY_ULR);
		
		System.out.println("2. Click on \"Create an account\"");
		homePage.clickLinkCreateAccount();

		System.out.println("3. Enter valid information into all fields");
		System.out.println("4. Click on \"Register\" button");
		RegisterPage reregisterPage = new RegisterPage();
		reregisterPage.registerByAccount(account);
		
		System.out.println("5. Get email information (webmail address, mailbox and password) and navigate to that webmail ");
		System.out.println("6. Login to the mailbox");
		WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
		Utilities.refreshWindow();
		System.out.println("7. Open email with subject containing \"Please confirm your account\"  and the email of the new account at step 3");
		System.out.println("8. Click on the activate link");

		String linkActiveString = guerrillamail.getLinkActive();
		Constant.WEBDRIVER.get(linkActiveString);
		
		System.out.println("Verify: That Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site.\" is shown");
		String expectedMsg = "Registration Confirmed! You can now log in to the site.";
		String acualMSg = reregisterPage.getRegisterConfirm();
		assertEquals(acualMSg, expectedMsg, "Registration Confirmed is shown");
		
	}
	
	@Test
	public void TC10 () {
		System.out.println("TC10: Reset password shows error if the new password is same as current");
		System.out.println("Pre-condition: an actived account is existing");
		Account account = Account.generalAccount();
		Guerrillamail guerrillamail = new Guerrillamail();
		guerrillamail.open();
		guerrillamail.setGuerrillaMail(account.getEmail());
		String mail = guerrillamail.getGmail();
		account.setEmail(mail);
		account.setPassword(Constant.PASSWORD);
		account.setPid(Constant.PID);
		
		HomePage homePage = new HomePage();
		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
		Utilities.getUrl(Constant.RAILWAY_ULR);
		
		RegisterPage reregisterPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		reregisterPage.registerByAccount(account);
		
		WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
		Utilities.refreshWindow();
		
		String linkActiveString = guerrillamail.getLinkActive();
		
		System.out.println("1. Navigate to QA Railway Login page");
		
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		
		System.out.println("2. Click on \"Forgot Password page\" link");
		
		loginPage.clickResetPassLinkTxt();
		
		System.out.println("3. Enter the email address of the activated account");
		System.out.println("4. Click on \"Send Instructions\" button");
		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.getEmailResetPassWord(account.getEmail());
		
		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		System.out.println("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		
		WindowManager.newTab(Constant.WINDOW_TAB_MAIL);
		guerrillamail.setGuerrillaMail(account.getEmail());
		Utilities.refreshWindow();
		String linkResetPass = guerrillamail.getLinkResetPassword();
		Constant.WEBDRIVER.get(linkResetPass);
		
		String newPassword = Common.RandomString.generateRandomString(12);
		changePasswordPage.resetPassword(linkResetPass);
		
		System.out.println("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token");
	}
	
	@Test
	public void TC11 () {
		System.out.println("TC10: Reset password shows error if the new password is same as current");
		System.out.println("Pre-condition: an actived account is existing");
		Account account = Account.generalAccount();
		Guerrillamail guerrillamail = new Guerrillamail();
		guerrillamail.open();
		guerrillamail.setGuerrillaMail(account.getEmail());
		String mail = guerrillamail.getGmail();
		account.setEmail(mail);
		account.setPassword(Constant.PASSWORD);
		account.setPid(Constant.PID);
		
		HomePage homePage = new HomePage();
		WindowManager.newTab(Constant.WINDOW_TAB_RAILWAY);
		Utilities.getUrl(Constant.RAILWAY_ULR);
		
		RegisterPage reregisterPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		reregisterPage.registerByAccount(account);
		
		WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
		Utilities.refreshWindow();
		
		String linkActiveString = guerrillamail.getLinkActive();
		
		System.out.println("1. Navigate to QA Railway Login page");
		
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		
		System.out.println("2. Click on \"Forgot Password page\" link");
		
		loginPage.clickResetPassLinkTxt();
		
		System.out.println("3. Enter the email address of the activated account");
		System.out.println("4. Click on \"Send Instructions\" button");
		System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
		
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.getEmailResetPassWord(account.getEmail());
		
		System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
		System.out.println("7. Click on reset link");
		System.out.println("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
		System.out.println("9. Click Reset Password");
		
		WindowManager.newTab(Constant.WINDOW_TAB_MAIL);
		guerrillamail.setGuerrillaMail(account.getEmail());
		Utilities.refreshWindow();
		String linkResetPass = guerrillamail.getLinkResetPassword();
		Constant.WEBDRIVER.get(linkResetPass);
		
		String newPassword = Common.RandomString.generateRandomString(12);
		changePasswordPage.resetPassword(linkResetPass);
		
		System.out.println("Error message \"Could not reset password. Please correct the errors and try again.\" displays above the form.");
		System.out.println("Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.");
	}
}
