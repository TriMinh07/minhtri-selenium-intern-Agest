package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Common.Utilities;
import Element.TicketColumn;
import Element.TicketDepart;
import Element.TicketSeatType;

public class BookTicketPage extends GeneralPage {
	
	//locators
	private final By seDepartDate = By.xpath("//select[@name='Date']");
	private final By seDepartForm = By.xpath("//select[@name='DepartStation']");
	private final By seArriveAt = By.xpath("//select[@name='ArriveStation']");
	private final By seSeatType = By.xpath("//select[@name='SeatType']");
	private final By seTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
	
	private final By msgSuccessfulyBooked = By.xpath("//h1[@align='center']");
	
	private final String tableCellFormat = "//tr[@class='OddRow']/td[%d]";

	//elements

	//methods
	
	public BookTicketPage bookTicket(String departDate, TicketDepart departForm, TicketDepart arriveAt, TicketSeatType seatType, String ticketAmount) {
		
		Utilities.scrollToElement(Utilities.getElement(seDepartDate));
		Select selectDepartDate = new Select(Utilities.getElement(this.seDepartDate));
		Select selectDepartForm = new Select(Utilities.getElement(this.seDepartForm));
		Select selectArriveAt = new Select(Utilities.getElement(this.seArriveAt));
		Select selectSeatType = new Select(Utilities.getElement(this.seSeatType));
		Select selectTicketAmount = new Select(Utilities.getElement(this.seTicketAmount));
		

		selectDepartDate.selectByContainsVisibleText(departDate);
		selectDepartForm.selectByValue(departForm.getValue());
		selectArriveAt.selectByValue(arriveAt.getValue());
		System.out.println("2");
		selectSeatType.selectByValue(seatType.getValue());
		selectTicketAmount.selectByValue(ticketAmount);

		Utilities.getElement(this.btnBookTicket).click();
		
		return new BookTicketPage();
	}	
	
	public String getCellValue(TicketColumn column) {
	    String xpath = String.format(tableCellFormat, column.getIndex());
	    return Utilities.getArtribute(By.xpath(xpath), "textContent");
	}
	
	public String getSuccessfullyMsg() {
		return Utilities.getArtribute(msgSuccessfulyBooked, "textContent");
	}
	
	public String getArriveAtValue () {
		return Utilities.getArtribute(seArriveAt, "value");
	}
	
	public String getDepathFromValue () {
		return Utilities.getArtribute(seDepartForm, "value");
	}
	
	public BookTicketPage bookTicketOnTimeTable(String departDate, TicketSeatType seatType, String ticketAmount) {
			
			Utilities.scrollToElement(Utilities.getElement(seDepartDate));
			Select selectDepartDate = new Select(Utilities.getElement(this.seDepartDate));
			Select selectSeatType = new Select(Utilities.getElement(this.seSeatType));
			Select selectTicketAmount = new Select(Utilities.getElement(this.seTicketAmount));
			
			System.out.println(departDate);
			selectDepartDate.selectByContainsVisibleText(departDate);
			selectSeatType.selectByValue(seatType.getValue());
			selectTicketAmount.selectByValue(ticketAmount);
	
			Utilities.getElement(this.btnBookTicket).click();
			
			return new BookTicketPage();
	}
	
}
