package Railway;

//import java.time.Duration;
import Common.Utilities;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import Constant.Constant;

import Menu.MenuRailway;

public class GeneralPage {
	
	//locators
	private final By lbWelcomeMesssage = By.xpath("//div[@class='account']/strong");
	
	private final String tabMenuString ="//div[@id='menu']//a[normalize-space()='%s']";

	//elements
	
	protected WebElement getlbWelcomeMesssage() {
		return Constant.WEBDRIVER.findElement(lbWelcomeMesssage);
	}
	
	//methods
	
	public GeneralPage navigateMenu(MenuRailway menu) {
		By menuBy = By.xpath(String.format(this.tabMenuString, menu.getText()));
		Utilities.waitForClickable(menuBy);
		Utilities.getElement(menuBy).click();
		return PageFactoryManager.getPage(menu.getPageClass());
	}
	
	public String getWelcomeMesssage() {
		Utilities.waitForVisible(lbWelcomeMesssage);
		return this.getlbWelcomeMesssage().getAttribute("textContent");
	}
	
	public void clickToElement(String locator) {
        Constant.WEBDRIVER.findElement(By.xpath(locator)).click();
    }
}
