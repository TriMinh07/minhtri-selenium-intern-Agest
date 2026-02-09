package Railway;

import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
	
	private final By departDate = By.xpath("//label[contains(text(),'Depart date')]/following-sibling::select");

}
