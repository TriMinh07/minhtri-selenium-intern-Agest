package Railway;

import java.awt.Container;
import Constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class LogoutPage extends GeneralPage{
	
	//locators
	private final By btnLogout = By.xpath("//a[@href='/Account/Logout']");
	
	//elements
	
	public WebElement getBtnLogout() {
		return Constant.WEBDRIVER.findElement(btnLogout);
	}
	
	//methods
	
	public boolean isLogoutBtnDisplayed() {
		
		return Utilities.isElementInvisible(btnLogout);
	}
}
