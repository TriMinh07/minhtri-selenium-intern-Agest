package Railway;

//import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Account.Account;
import Constant.Constant;
import Element.RegistorError;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
	
	//locators
	private final By _txtEmail = By.xpath("//input[@name='email']");
	private final By _txtPassword = By.xpath("//input[@name='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
	private final By _txtPid = By.xpath("//input[@name='pid']");
	private final By _btnSubmitRegister = By.xpath("//input[@value='Register']");
	private final By lbErrorMessageBy = By.xpath("//p[@class='message error']");	

	private final String lbErrorMsg = ("//label[@for='%s'][ @class='validation-error']");
	private final By lbRegistrationConfirm = By.xpath("//div[@id='content']/p");
	
	//elements
	
	public WebElement getTxtEmail () {
		return Constant.WEBDRIVER.findElement(_txtEmail);
	}	
	
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	public WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}
	
	public WebElement getTxtPid () {
		return Constant.WEBDRIVER.findElement(_txtPid);
	}
	
	public WebElement getBtnSubmitRegister() {
		return Constant.WEBDRIVER.findElement(_btnSubmitRegister);
	}
	//methods
	
	public String getErrorMessage() {
		return Utilities.getText(this.lbErrorMessageBy);
	}
	
	public HomePage registerByAccount(Account account) {
		Utilities.scrollToElement(getTxtPassword());
		Utilities.type(_txtEmail, account.getEmail());
		Utilities.type(_txtPassword, account.getPassword());
		Utilities.type(_txtConfirmPassword, account.getPassword());
		Utilities.type(_txtPid, account.getPid());
		Utilities.click(_btnSubmitRegister);
		return new HomePage();
	}
	
	public By getErrorLocator(RegistorError field) {
	    return By.xpath(String.format( this.lbErrorMsg, field.getValue()));
	}
	
	public String getErrorMessageOfField(RegistorError field) {
	    return Constant.WEBDRIVER.findElement(getErrorLocator(field)).getText();
	}
	
	public String getRegisterConfirm() {
		return Utilities.getArtribute(lbRegistrationConfirm, "textContent");
	}
	
	public void activateAccount(String link) {
	    WindowManager.switchToTab(Constant.WINDOW_TAB_RAILWAY);
	    Constant.WEBDRIVER.get(link);
	}
}
