package Railway;

import Constant.Constant;

public class HomePage extends GeneralPage {

	//Locators
	
	//elements
	
	//methods
	
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_ULR);
		return this;
	}
	
}
