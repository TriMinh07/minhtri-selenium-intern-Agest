package Railway;

//import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Account.Account;
import Constant.Constant;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
	
	//locators
	private final By _txtEmail = By.xpath("//input[@name='email']");
	private final By _txtPassword = By.xpath("//input[@name='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
	private final By _txtPid = By.xpath("//input[@name='pid']");
	private final By _btnSubmitRegister = By.xpath("//input[@value='Register']");
	private final By _lbErrorMsg = By.xpath("//p[@class='message error']");
	private final By lbErrorMessageBy = By.xpath("//p[@class='message error']");	

	private final By lbConfirmPassWordErrorMsg = By.xpath("//label[@for='confirmPassword'][ @class='validation-error']");
	private final By lbPassWordErrorMsg = By.xpath("//label[@for='password'][ @class='validation-error']");
	private final By lbEmailErrorMsg = By.xpath("//label[@for='email'][ @class='validation-error']");
	private final By lbPidErrorMsg = By.xpath("//label[@for='pid'][ @class='validation-error']");
	//elements
	
	public String getErrorMessage() {
		return Utilities.getText(this.lbErrorMessageBy);
	}
	
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
	
	public HomePage registerByAccount(Account account) {
		Utilities.type(_txtEmail, account.getEmail());
		Utilities.type(_txtPassword, account.getPassword());
		Utilities.type(_txtConfirmPassword, account.getPassword());
		Utilities.type(_txtPid, account.getPid());
		Utilities.click(_btnSubmitRegister);
		return new HomePage();
	}
}
