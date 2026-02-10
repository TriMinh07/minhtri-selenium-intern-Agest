package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class HomePage extends GeneralPage {

	//Locators
	private final By lnkCreateAccount = By.xpath("//a[text()='create an account']");
	
	//elements
	
	//methods
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_ULR);
		return this;
	}
	
	public void clickLinkCreateAccount() {
		
	}
	
}
