package Railway;

import java.nio.channels.InterruptibleChannel;
import java.text.Format;

import org.openqa.selenium.By;
import org.openqa.selenium.bidi.storage.PartialCookie;

import Common.Utilities;
import Element.TicketSeatType;

public class TicketPricePage extends GeneralPage {
	
	//Locators
	
	private final String cellValue = "//tr[th[contains(.,'Price')]]/td[count(//tr[th[contains(.,'Seat type')]]/td[normalize-space()='%s']/preceding-sibling::td) + 1]";
	
	private final By headerText = By.xpath("//tr[@class='TableSmallHeader']");
	
	//elements
	
	//methods
	
	public String getCellTicketPrice(TicketSeatType miniName) {
		By xpath = By.xpath(String.format(this.cellValue, miniName.getMiniName()));
		return Utilities.getText(xpath);
	}
	
	public String getTableTitle() {
		return Utilities.getArtribute(headerText, "textContent");
	}

}
