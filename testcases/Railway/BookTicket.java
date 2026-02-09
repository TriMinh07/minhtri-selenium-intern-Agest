package Railway;

import Constant.Constant;
import Menu.MenuRailway;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicket extends BaseTest {
	
	@Test
	public void TC12  () {
		System.out.println("Pre-condition: an actived account is existing");
		
		HomePage homePage = new HomePage();
		System.out.println("1. Navigate to QA Railway Website");
		homePage.open();
		System.out.println("2. Login with valid Email and Password");
		
		LoginPage loginPage = (LoginPage) homePage.navigateMenu(MenuRailway.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		
		BookTicketPage bookTicketPage = new BookTicketPage();
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		
		
		
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		
		System.out.println("8. Click on \"Book ticket\" button");
	}
}
