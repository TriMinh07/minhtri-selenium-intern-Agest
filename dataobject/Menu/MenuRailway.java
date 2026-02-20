package Menu;

import Railway.ChangePasswordPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.TimeTablePage;
import Railway.FAQPage;
import Railway.GeneralPage;
import Railway.RegisterPage;
import Railway.TicketPricePage;
import Railway.ContactPage;
import Railway.LogoutPage;
import Railway.MyTicketPage;
import Railway.BookTicketPage;


public enum MenuRailway {
	
    HOME("Home", HomePage.class),
    LOGOUT("Logout", LogoutPage.class),
    FAQ("FAQ", FAQPage.class),
    CONTACT("Contact", ContactPage.class),
    TIMETABLE("Timetable",TimeTablePage.class),
    TICKET_PRICE("Ticket price", TicketPricePage.class),
    BOOK_TICKET("Book ticket", BookTicketPage.class),
    REGISTER("Register", RegisterPage.class),
    LOGIN("Login", LoginPage.class),
	CHANGE_PASSWORD("Change password", ChangePasswordPage.class),
	MY_TICKET ("My ticket" , MyTicketPage.class );

    private final String displayText;
    private final Class<? extends GeneralPage> pageClass;

    MenuRailway(String displayText, Class<? extends GeneralPage> pageClass) {
        this.displayText = displayText;
        this.pageClass = pageClass;
    }

    public String getText() {
        return displayText;
    }
    
    public Class<? extends GeneralPage> getPageClass() {
    	return this.pageClass;
    }

}
