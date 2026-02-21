package Railway;


import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Account.Account;
import Common.UtilsDate;

import Element.TicketColumn;
import Element.TicketDepart;
import Element.TicketSeatType;
import Menu.MenuRailway;

public class BookTicket extends BaseTest {
	
	@Test
	public void TC12  () {
		System.out.println("Pre-condition: an actived account is existing");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		
		String expectedMsg = "Ticket booked successfully!";
		
		String departDate = UtilsDate.getFutureDate(5);
		TicketDepart depart = TicketDepart.NHATRANG;
		TicketDepart departFrom = TicketDepart.HUE;
		TicketSeatType typeSeat = TicketSeatType.SOFT_BED_AIR ;
		String amount = "1";
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with valid Email and Password");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.navigateMenu(MenuRailway.BOOK_TICKET);
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Huế\" for \"Arrive at\".");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		System.out.println("8. Click on \"Book ticket\" button");
//		departDate -> TicketDepart -> TicketDepart from  -> TicketSeatType  ->	TicketAmount 
		bookTicketPage.bookTicket(departDate, depart , departFrom, typeSeat , amount);
		
		System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information "
				+ "display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getSuccessfullyMsg().trim();

		Assert.assertEquals(actualMsg, expectedMsg, "successfully message is displayed");
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.DEPART_STATION), depart.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.ARRIVE_STATION), departFrom.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.SEAT_TYPE), typeSeat.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.AMOUNT), amount);

	}
	
	@Test
	public void TC13  () {
		System.out.println("Pre-condition: an actived account is existing");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		
		String expectedMsg = "Ticket booked successfully!";
		
		String amount = "5";
		TicketSeatType typeSeat = TicketSeatType.SOFT_SEAT_AIR ;
		String departDate = UtilsDate.getFutureDate(28);
		TicketDepart depart = TicketDepart.NHATRANG;
		TicketDepart departFrom = TicketDepart.SAIGON;
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);

		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.navigateMenu(MenuRailway.BOOK_TICKET);
		
		System.out.println("4. Select the next 25 days from \"Depart date\"");
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"5\" for \"Ticket amount\"");
		System.out.println("8. Click on \"Book ticket\" button");
//		departDate -> TicketDepart -> TicketDepart from  -> TicketSeatType  ->	TicketAmount 
		bookTicketPage.bookTicket(departDate, depart , departFrom, typeSeat , amount);
		
		System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information display correctly "
				+ "(Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getSuccessfullyMsg().trim();

		Assert.assertEquals(actualMsg, expectedMsg, "successfully message is displayed");
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.DEPART_STATION), depart.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.ARRIVE_STATION), departFrom.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.SEAT_TYPE), typeSeat.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.AMOUNT), amount);
	}
	
	@Test
	public void TC14 () {
		System.out.println("User can check price of ticket from Timetable");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		
		String exHS = "310000";
		String exSS = "335000";
		String exSSC = "360000";
		String exHB = "410000";
		String exSB = "460000";
		String exSBC = "510000";
		String exTitle = "Ticket price from Đà Nẵng to Sài Gòn";
		
		String depart = TicketDepart.DANANG.getName();
		String departForm = TicketDepart.SAIGON.getName();
		String action = "check price";
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = (TimeTablePage) homePage.navigateMenu(MenuRailway.TIMETABLE);
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		timeTablePage.clickLinkByRoute(depart, departForm, action);
		
		System.out.println("\"Ticket Price\" page is loaded.\r\n"
				+ "Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".\r\n"
				+ "Price for each seat displays correctly\r\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
		
		TicketPricePage ticketPrice = new TicketPricePage();
		
		Assert.assertEquals(ticketPrice.getTableTitle().trim(), exTitle);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.HARD_BED), exHB);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.HARD_SEAT), exHS);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_BED), exSB);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_BED_AIR), exSBC);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_SEAT), exSS);
		Assert.assertEquals(ticketPrice.getCellTicketPrice(TicketSeatType.SOFT_SEAT_AIR), exSSC);
	}
	
	@Test
	public void TC15 () {
		System.out.println("User can book ticket from Timetable");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		BookTicketPage bookTicketPage = new BookTicketPage();
		
		String expectedMsg = "Ticket booked successfully!";
		
		String departFrom = TicketDepart.QUANGNGAI.getName();
		String departArrive = TicketDepart.HUE.getName();
		String action = "book ticket";
		String Date = UtilsDate.getFutureDate(2);
		String Amount = "5";
		TicketSeatType typeSeat = TicketSeatType.HARD_SEAT;
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = (TimeTablePage) homePage.navigateMenu(MenuRailway.TIMETABLE);
		
		System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
		timeTablePage.clickLinkByRoute(departFrom, departArrive, action);
		
		System.out.println("Verify: Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"");
		String actualOptionFrom = bookTicketPage.getDepathFromValue();
		String actualOptionArriveAt = bookTicketPage.getArriveAtValue();
		Assert.assertEquals(TicketDepart.QUANGNGAI.getValue(), actualOptionFrom, "corrected \"depart from\" Quảng Ngãi");
		Assert.assertEquals(TicketDepart.HUE.getValue(), actualOptionArriveAt, "corrected \"Arrive at\" Huế");
		
		System.out.println("5. Select Depart date = tomorrow");
		System.out.println("6. Select Ticket amount = 5");
		System.out.println("7. Click on \"Book ticket\" button");

		bookTicketPage.bookTicketOnTimeTable(Date, typeSeat , Amount );
		
		System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		
		String actualMsg = bookTicketPage.getSuccessfullyMsg().trim();

		Assert.assertEquals(actualMsg, expectedMsg, "successfully message is displayed");
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.DEPART_STATION), departFrom);
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.ARRIVE_STATION), departArrive);
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.SEAT_TYPE), typeSeat.getName());
		Assert.assertEquals(bookTicketPage.getCellValue(TicketColumn.AMOUNT), Amount);
	}
	
	@Test
	public void TC16 () {
		System.out.println("User can book ticket from Timetable");
		HomePage homePage = new HomePage();
		Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
		
		Boolean expected = false;
		
		String departDate = UtilsDate.getFutureDate(5);
		TicketDepart depart = TicketDepart.NHATRANG;
		TicketDepart departFrom = TicketDepart.HUE;
		TicketSeatType typeSeat = TicketSeatType.SOFT_BED_AIR ;
		String amount = "1";
		String TicketNumBer = "1";
		
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(account);
		
		System.out.println("3. Book a ticket");
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.navigateMenu(MenuRailway.BOOK_TICKET);

//		departDate -> TicketDepart -> TicketDepart from  -> TicketSeatType  ->	TicketAmount 
		bookTicketPage.bookTicket(departDate, depart , departFrom, typeSeat , amount);

		System.out.println("4. Click on \"My ticket\" tab");
		MyTicketPage myTicketPage = (MyTicketPage) homePage.navigateMenu(MenuRailway.MY_TICKET);
		
		System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
		System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
		myTicketPage.ClickCancelTicket(TicketNumBer);
		
		System.out.println("verify: The canceled ticket is disappeared.");
		Assert.assertEquals(myTicketPage.checkCancelTicketIsVisible(TicketNumBer), expected, "The canceled ticket is disappeared.");
		
	}
	
}
