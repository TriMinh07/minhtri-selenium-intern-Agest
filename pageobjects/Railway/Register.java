package Railway;

//import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.Utilites;

public class Register {
	//locators
	private final By _txtEmail = By.xpath("//input[@name='email']");
	private final By _txtPassword = By.xpath("//input[@name='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
	private final By _txtPid = By.xpath("//input[@name='pid']");
	private final By _btnSubmitRegister = By.xpath("//input[@value='Register']");
	private final By _lbErrorMsg = By.xpath("//p[@class='message error']");
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
	
	public HomePage registor(String email, String password, String passport) {
		Utilites.scrollToElement(getTxtEmail());
		this.getTxtPassword().clear();
		this.getTxtPassword().sendKeys(password);
		this.getTxtEmail().click();
		this.getTxtEmail().sendKeys(email);
		this.getTxtConfirmPassword().sendKeys(passport);
		this.getBtnSubmitRegister().click();
		return new HomePage();
	}
}
