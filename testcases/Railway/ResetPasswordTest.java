package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Account.Account;
import Common.Utilities;
import Constant.Constant;
import Menu.MenuRailway;

public class ResetPasswordTest extends BaseTest {
	
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
		homePage.SwitchToNewTabRailway();
		
		RegisterPage reregisterPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		reregisterPage.registerByAccount(account);
		
		guerrillamail.switchToMailTab();
		
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
		
		guerrillamail.switchToMailTab();
		guerrillamail.setGuerrillaMail(account.getEmail());
		Utilities.refreshWindow();
		String linkResetPass = guerrillamail.getLinkResetPassword();
		
		String newPassword = Common.RandomString.generateRandomString(12);
		changePasswordPage.resetPassword(newPassword);
		
		System.out.println("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token");
	}
	
	@Test
	public void TC11 () {
		System.out.println("TC11: Reset password shows error if the new password is same as current");
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
		changePasswordPage.resetPassword(newPassword);
		
		String expectedErrorMsg = "Could not reset password. Please correct the errors and try again.";
		String expectedComfirmErrorMsg = "The password confirmation did not match the new password.";
		String actualErrorMsg = changePasswordPage.getLbErrorMsg();
		String actualConfitmErrorMsg = changePasswordPage.getLbInvalidConfirmPassErrorMsg(); 
		System.out.println("Error message \"Could not reset password. Please correct the errors and try again.\" displays above the form.");
		
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message \"Could not reset password. Please correct the errors and try again.\"is displayed");
		
		System.out.println("Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.");
		
		Assert.assertEquals(actualConfitmErrorMsg, expectedComfirmErrorMsg, "Error message \"The password confirmation did not match the new password.\" is displayed");
	}

}
