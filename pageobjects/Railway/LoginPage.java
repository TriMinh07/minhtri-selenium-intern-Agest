package Railway;

import Common.Utilites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends GeneralPage {
	
	//locators
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lbLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	//wait
	private final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
	//elements
	public WebElement getTxtUsrename() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	
	public WebElement getLbLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lbLoginErrorMsg);
	}
	//methods
	
	public HomePage login(String username, String password) {
		// Sub login credentials
		this.getTxtUsrename().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		return new HomePage();
	}
	
	public String getErrorMessage() {
		this.waitForVisible(_lbLoginErrorMsg);
		return getLbLoginErrorMsg().getAttribute("textContent");
	}
	
}
