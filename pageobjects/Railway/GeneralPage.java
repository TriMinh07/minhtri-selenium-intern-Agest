package Railway;

//import java.time.Duration;
import Common.Utilites;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class GeneralPage {
	
	//locators
	private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	private final By tabLogon = By.xpath("//a[@href='/Account/Register.cshtml']");
	private final By tabFAQ = By.xpath("//a[@href='/Page/FAQ.cshtml']");
	private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
	private final By lbWelcomeMesssage = By.xpath("//div[@class='account']/strong");
	
	

	//elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTabLogon() {
		return Constant.WEBDRIVER.findElement(tabLogon);
	}
	
	protected WebElement getlbWelcomeMesssage() {
		return Constant.WEBDRIVER.findElement(lbWelcomeMesssage);
	}
	
	protected WebElement getTablogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getTabFAQ() {
		return Constant.WEBDRIVER.findElement(tabFAQ);
	}
	
	//methods
	public String getWelcomeMesssage() {
		Utilites.waitForVisible(lbWelcomeMesssage);
		return this.getlbWelcomeMesssage().getAttribute("textContent");
	}
//	genaric sau
	public LoginPage gotoLoginPage() {
		Utilites.waitForVisible(tabLogin);
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public Register gotoRegiser() {
		Utilites.waitForVisible(tabLogon);
		this.getTabLogon().click();
		return new Register();
	}
	
	public HomePage gotoFAQ() {
		Utilites.waitForVisible(tabFAQ);
		this.getTabFAQ().click();
		return new HomePage();
	}
	
	public HomePage clickLogout() {
		Utilites.waitForVisible(tabLogout);
		this.getTablogout().click();
		return new HomePage();
	}
	
	public boolean isLogoutTabisDisplayed() {
	        return Utilites.isElementInvisible(tabLogout);
	}
}
