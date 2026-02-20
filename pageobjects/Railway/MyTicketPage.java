package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class MyTicketPage extends GeneralPage {
	
	//locators
	String MyTicketLinkXpathForm = "//table[@class='MyTable']//tr[td[1][text()='%s']]//input[@value='Cancel']";
	
	//methods
	public MyTicketPage ClickCancelTicket(String Number) {
	
		String xpath = String.format(MyTicketLinkXpathForm, Number);
		Utilities.click(By.xpath(xpath));
		Constant.WEBDRIVER.switchTo().alert().accept();
		return new MyTicketPage();
	}
	
	public Boolean checkCancelTicketIsVisible(String Number) {
		String xpath = String.format(MyTicketLinkXpathForm, Number);
		if (Utilities.isDisplayElement(By.xpath(xpath))) {
			return true;
		}
		return false;
	}
	
}
