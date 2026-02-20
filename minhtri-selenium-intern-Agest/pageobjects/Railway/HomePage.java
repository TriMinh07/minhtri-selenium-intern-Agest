package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class HomePage extends GeneralPage {

	//Locators
	private final By linkCreateAccount = By.xpath("//a[text()='create an account']");
	
	//elements

	protected WebElement getLinkCreateAccount() {
		return Constant.WEBDRIVER.findElement(linkCreateAccount);
	}
	
	//methods
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_ULR);
		return this;
	}
	
	public HomePage clickLinkCreateAccount() {
		Utilities.scrollToElement(getLinkCreateAccount());
		Constant.WEBDRIVER.findElement(linkCreateAccount).click();
		return new HomePage();
	}
	
}
