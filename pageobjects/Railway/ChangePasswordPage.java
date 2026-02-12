package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class ChangePasswordPage extends GeneralPage {
	// locators
	private final By inputEmailResetPass  		= By.xpath("//input[@name='email']");
	private final By btnSendInstruction 		= By.xpath("//input[@value='Send Instructions']");
	private final By inputNewPassword 			= By.xpath("//input[@name='newPassword']");
	private final By inputConfirmNewPassword	= By.xpath("//input[@name='confirmPassword']");
	private final By btnResetPassword 			= By.xpath("//input[@value='Reset Password']");
	//elements
	
	//methods
	
	public HomePage getEmailResetPassWord (String email) {
		
		Utilities.getElement(inputEmailResetPass).sendKeys(email);
		Utilities.click(btnSendInstruction);
		return new HomePage();
	}
	
	public ChangePasswordPage resetPassword (String newPassword) {
		Utilities.getElement(inputNewPassword).sendKeys(newPassword);
		Utilities.getElement(inputConfirmNewPassword).sendKeys(newPassword);
		Utilities.click(btnResetPassword);
		return new ChangePasswordPage();
	}
}
