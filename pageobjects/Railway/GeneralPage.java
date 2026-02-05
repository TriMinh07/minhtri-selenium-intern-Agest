package Railway;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class GeneralPage {
	
	//locators
	private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	private final By tabLogon = By.xpath("//a[@href='/Account/Register.cshtml']");
	private final By lbWelcomeMesssage = By.xpath("//div[@class='account']/strong");
	
	private final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
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
	
	//methods
	public String getWelcomeMesssage() {
		this.waitForVisible(lbWelcomeMesssage);
		return this.getlbWelcomeMesssage().getAttribute("textContent");
	}
	
	public WebElement waitForVisible(By locator) {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
	
}
