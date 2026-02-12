package Railway;

import Constant.Constant;
import Element.TicketAmount;
import Element.TicketColumn;
import Element.TicketDepart;
import Element.TicketSeatType;
import Menu.MenuRailway;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Account.Account;
import Common.UtilsDate;

public class BookTicket extends BaseTest {
	
	@Test
	public void TC12  () {
		System.out.println("Pre-condition: an actived account is existing");
		
		HomePage homePage = new HomePage();
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		System.out.println("2. Login with valid Email and Password");
		
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		
		
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.navigateMenu(MenuRailway.BOOK_TICKET);
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		String departDate = UtilsDate.getFutureDate(5);
		
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Huế\" for \"Arrive at\".");
		TicketDepart depart = TicketDepart.NHATRANG;
		TicketDepart departFrom = TicketDepart.HUE;
		
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		TicketSeatType typeSeat = TicketSeatType.SOFT_BED_AIR ;
		
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		TicketAmount amount = TicketAmount.ONE;
		
		System.out.println("8. Click on \"Book ticket\" button");
//		departDate -> TicketDepart -> TicketDepart from  -> TicketSeatType  ->	TicketAmount 
		bookTicketPage.bookTicket(departDate, depart , departFrom, typeSeat , amount);
		
		System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		
		SoftAssert softAssert = new SoftAssert();
		
		String actualMsg = bookTicketPage.getSuccessfullyMsg().trim();
		String expectedMsg = "Ticket booked successfully!";
		softAssert.assertEquals(actualMsg, expectedMsg, "successfully message is displayed");
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.DEPART_STATION), depart.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.ARRIVE_STATION), departFrom.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.SEAT_TYPE), typeSeat.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.AMOUNT), amount.getValue());
		softAssert.assertAll();
	}
	
	@Test
	public void TC13  () {
		System.out.println("Pre-condition: an actived account is existing");
		
		HomePage homePage = new HomePage();
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		System.out.println("2. Login with a valid account ");
		
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		
		
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.navigateMenu(MenuRailway.BOOK_TICKET);
		
		System.out.println("4. Select the next 25 days from \"Depart date\"");
		String departDate = UtilsDate.getFutureDate(28);
		System.out.println(departDate);
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		TicketDepart depart = TicketDepart.NHATRANG;
		TicketDepart departFrom = TicketDepart.SAIGON;
		
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		TicketSeatType typeSeat = TicketSeatType.SOFT_SEAT_AIR ;
		
		System.out.println("7. Select \"5\" for \"Ticket amount\"");
		TicketAmount amount = TicketAmount.FIVE;
		
		System.out.println("8. Click on \"Book ticket\" button");
//		departDate -> TicketDepart -> TicketDepart from  -> TicketSeatType  ->	TicketAmount 
		bookTicketPage.bookTicket(departDate, depart , departFrom, typeSeat , amount);
		
		System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		
		SoftAssert softAssert = new SoftAssert();
		
		String actualMsg = bookTicketPage.getSuccessfullyMsg().trim();
		String expectedMsg = "Ticket booked successfully!";
		softAssert.assertEquals(actualMsg, expectedMsg, "successfully message is displayed");
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.DEPART_STATION), depart.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.ARRIVE_STATION), departFrom.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.SEAT_TYPE), typeSeat.getName());
		softAssert.assertEquals(bookTicketPage.getCellValue(TicketColumn.AMOUNT), amount.getValue());
		softAssert.assertAll();
	}
	
	@Test
	public void TC14 () {
		System.out.println("User can check price of ticket from Timetable");
		
		HomePage homePage = new HomePage();
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = (TimeTablePage) homePage.navigateMenu(MenuRailway.TIMETABLE);
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		String depart = TicketDepart.DANANG.getName();
		String departForm = TicketDepart.SAIGON.getName();
		String action = "check price";
		
		timeTablePage.clickLinkByRoute(depart, departForm, action);
		
		
		System.out.println("\"Ticket Price\" page is loaded.\r\n"
				+ "Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".\r\n"
				+ "Price for each seat displays correctly\r\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
		String exHS = "310000";
		String exSS = "335000";
		String exSSC = "360000";
		String exHB = "410000";
		String exSB = "460000";
		String exSBC = "510000";
		String exTitle = "Ticket price from Đà Nẵng to Sài Gòn";
		
		TicketPricePage ticketPrice = new TicketPricePage();
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(ticketPrice.getTableTitle().trim(), exTitle);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.HARD_BED), exHB);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.HARD_SEAT), exHS);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_BED), exSB);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_BED_AIR), exSBC);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_SEAT), exSS);
		softAssert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_SEAT_AIR), exSSC);
		
		softAssert.assertAll();
		
	}
	
	
}
