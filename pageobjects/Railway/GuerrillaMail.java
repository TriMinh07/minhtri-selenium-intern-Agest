package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class Guerrillamail {
	private final By lbIdEmailBy = By.xpath("//span[@id='inbox-id']");
	private final By txtNameEmailBy = By.xpath("//span[@id='inbox-id']/input");
	private final By btnSetNameEmailBy = By.xpath("//button[text()='Set']");
	private final By lbEmailBy = By.xpath("//span[@id='email-widget']");
	private final By checkAliasBy = By.xpath("//input[@id='use-alias']");
	private final By boxEmailConfirmAccountBy = By.xpath("//tr[contains(@class, 'mail_row')]//a[contains(., 'Please confirm')]"); 
	private final By linkActiveAccountBy = By.xpath("//div[@class='email_body']/a");
	private final By boxEmailResetPasswordBy = By.xpath("//td[contains(text(),'Please reset your password')]");
	private final By linkActiveResetPasswordBy = By.xpath("//div[@class='email_body']/a");
	private final By btnBackToInboxBy = By.xpath("//a[@id='back_to_inbox_link']");
	
	private final By btnExitAdvert = By.xpath("//div[@class='btn skip']");
	
	public void setGuerrillaMail(String emailName) {
		Utilities.clickByJS(this.lbIdEmailBy);
		Utilities.clearAndType(this.txtNameEmailBy, emailName);
		Utilities.clickByJS(this.btnSetNameEmailBy);
	}
	
	public WebElement getBackToInboxElement() {
		return Utilities.getElement(this.btnBackToInboxBy);
	}
	
	public String getGmail() {
		Utilities.click(this.checkAliasBy);
		return Utilities.getText(this.lbEmailBy);
	}
	
	public String getLinkActive() {
		Utilities.waitForElementWithRefresh(boxEmailConfirmAccountBy, 10, 5); 
		Utilities.clickByJS(this.boxEmailConfirmAccountBy);
		return Utilities.getArtribute(this.linkActiveAccountBy, "href");
	}
	
	public RegisterPage ClickLinkActive() {
		String linkActive = getLinkActive();
		Utilities.getUrl(linkActive);
		return new RegisterPage();
	}
	
	public String getLinkResetPassword() {
		Utilities.refreshWindow();
		
		Utilities.clickByJS(this.boxEmailResetPasswordBy);
		return Utilities.getArtribute(this.linkActiveResetPasswordBy, "href");
	}
	
	public Guerrillamail open() {
		Constant.WEBDRIVER.navigate().to(Constant.MAIL_ULR);
		WindowManager.saveWindow(Constant.WINDOW_TAB_MAIL, Constant.WEBDRIVER);
		return this;
	}
	
	public void switchToMailTab() {
	    WindowManager.switchToTab(Constant.WINDOW_TAB_MAIL);
	}
}
