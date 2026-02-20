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
	
	private final By lbErrorMsg = By.xpath("//p[@class='message error']");
	private final By lbInvalidPassErrorMsg = By.xpath("//label[@for='currentPassword'][@class='validation-error']");
	private final By lbInvalidCurrentErrorMsg = By.xpath("//label[@for='newPassword'][@class='validation-error']");
	private final By lbInvalidConfirmPassErrorMsg = By.xpath("//label[@for='confirmPassword'][@class='validation-error']");
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
	
	public ChangePasswordPage resetPassword (String newPassword, String confirmPassword) {
		Utilities.getElement(inputNewPassword).sendKeys(newPassword);
		Utilities.getElement(inputConfirmNewPassword).sendKeys(confirmPassword);
		Utilities.click(btnResetPassword);
		return new ChangePasswordPage();
	}
	
	public String getLbErrorMsg () {
		return Utilities.getArtribute(lbErrorMsg, "textContent");
	}
	
	public String getLbInvalidPassErrorMsg () {
		return Utilities.getArtribute(lbInvalidPassErrorMsg, "textContent");
	}
	
	public String getLbInvalidCurrentErrorMsg () {
		return Utilities.getArtribute(lbInvalidCurrentErrorMsg, "textContent");
	}
	
	public String getLbInvalidConfirmPassErrorMsg () {
		return Utilities.getArtribute(lbInvalidConfirmPassErrorMsg, "textContent");
	}
	
}
