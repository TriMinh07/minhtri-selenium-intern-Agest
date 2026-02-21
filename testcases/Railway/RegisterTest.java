package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Account.Account;
import Constant.Constant;
import Element.RegistorError;
import Menu.MenuRailway;

public class RegisterTest extends BaseTest {

	@Test
	public void TC07() {

		Account account = Account.generalAccount();
		String expectedMessageString = Constant.REGISTER_MESSAGE_ERROR_DUPLICAP_MAIL;

		System.out.println("TC07: User can't create account with an already in-use email");

		Guerrillamail guerrillamail = new Guerrillamail();
		guerrillamail.open();
		account.setEmail(guerrillamail.getGmail());

		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.SwitchToNewTabRailway();

		System.out.println("2. Click on Register tab & Register first time");
		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		registerPage.registerByAccount(account);

		System.out.println("3. Activate the account");
		guerrillamail.switchToMailTab();
		String linkActiveString = guerrillamail.getLinkActive();

		registerPage.activateAccount(linkActiveString);

		System.out.println("4. Register again with same account");
		registerPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		registerPage.registerByAccount(account);

		String actualMessageString = registerPage.getErrorMessage();
		Assert.assertEquals(actualMessageString.trim(), expectedMessageString.trim());
	}

	@Test
	public void TC08() {

		System.out.println("TC08: User can't create account while password and PID fields are empty");
		String expectedRegisterErrMsg = "There're errors in the form. Please correct the errors and try again.";
		String expectedPassErrMsg = "Invalid password length";
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME);
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Click on \"Register\" tab");
		RegisterPage registerPage = (RegisterPage) homePage.navigateMenu(MenuRailway.REGISTER);
		
		System.out.println("3. Enter valid email address and leave other fields empty");
		System.out.println("4. Click on \"Register\" button");
		System.out.println(
				"Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
		registerPage.registerByAccount(account);

		String registerErrMsg = registerPage.getErrorMessage();
		Assert.assertEquals(registerErrMsg.trim(), expectedRegisterErrMsg, "Error message is displayed");
		System.out.println("Next to password fields");

		System.out.println("Verify: That error message \"Invalid password length.\" displays");
		String passwordErrMsg = registerPage.getErrorMessageOfField(RegistorError.REGISTER_PASSWORD_ERROR);

		Assert.assertEquals(passwordErrMsg.trim(), expectedPassErrMsg,
				"error message \"Invalid password length.\" displays");
		
		System.out.println("Next to PID field");
		System.out.println("Verify: That error message \"Invalid ID length.\" displayed");
		String pidErrMsg = registerPage.getErrorMessageOfField(RegistorError.REGISTER_PID_ERROR);
		String expectedPidErrMsg = "Invalid ID length";
		Assert.assertEquals(pidErrMsg.trim(), expectedPidErrMsg, "error message \"Invalid ID length.\" displayed");
	}

	@Test
	public void TC09() {

		System.out.println("TC09: User can't create account while password and PID fields are empty");
		Guerrillamail guerrillamail = new Guerrillamail();
		Account account = Account.generalAccount();
		HomePage homePage = new HomePage();
		RegisterPage reregisterPage = new RegisterPage();

		guerrillamail.open();
		guerrillamail.setGuerrillaMail(account.getEmail());
		String mail = guerrillamail.getGmail();
		account.setEmail(mail);
		account.setPassword(Constant.PASSWORD);
		account.setPid(Constant.PID);

		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.SwitchToNewTabRailway();

		System.out.println("2. Click on \"Create an account\"");
		homePage.clickLinkCreateAccount();

		System.out.println("3. Enter valid information into all fields");
		System.out.println("4. Click on \"Register\" button");
		reregisterPage.registerByAccount(account);

		System.out.println(
				"5. Get email information (webmail address, mailbox and password) and navigate to that webmail ");
		System.out.println("6. Login to the mailbox");
		guerrillamail.switchToMailTab();
		guerrillamail.setGuerrillaMail(account.getEmail());

		
		System.out.println(
				"7. Open email with subject containing \"Please confirm your account\" and the email of the new account at step 3");
		System.out.println("8. Click on the activate link");
		guerrillamail.getLinkActive();
		guerrillamail.ClickLinkActive();
		System.out.println(
				"Verify: That Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site.\" is shown");
		String expectedMsg = "Registration Confirmed! You can now log in to the site.";
		String acualMSg = reregisterPage.getRegisterConfirm();
		Assert.assertEquals(acualMSg, expectedMsg, "Registration Confirmed is shown");
	}
}