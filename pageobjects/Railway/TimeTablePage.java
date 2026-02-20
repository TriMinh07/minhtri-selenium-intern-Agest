package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class TimeTablePage extends GeneralPage {

	//Locators
	
	String xpathTemplate = "//tr[td[count(//th[normalize-space()='Depart Station']/preceding-sibling::th)+1]"
            + "[normalize-space()='%s'] and "
            + "td[count(//th[normalize-space()='Arrive Station']/preceding-sibling::th)+1]"
            + "[normalize-space()='%s']]"
            + "//a[normalize-space()='%s']";
	//elements
	
	//methods
	
	public void clickLinkByRoute(String depart, String arrive, String action) {
		
        String finalXpath = String.format(xpathTemplate, depart, arrive, action);
        
        Utilities.click(By.xpath(finalXpath));
    }
	
}
