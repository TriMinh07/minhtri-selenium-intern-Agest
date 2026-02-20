package Railway;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import Constant.Constant;

public class WindowManager {
	
	//Locators
	private static Map<String, String> windowMap = new HashMap<>();
	
	//methods
	public static void saveWindow(String name, WebDriver webDriver) {
		windowMap.put(name, webDriver.getWindowHandle());
	}
	
	public static void switchToTab(String name) {
		String handleString = windowMap.get(name);
		
		if(handleString == null) {
			throw new RuntimeException("No window find name: " + name);		
		}
		
		Constant.WEBDRIVER.switchTo().window(handleString);
	}
	
	public static void switchToWindowByTitle(String expectedTitle) {
 	    for (String handle : Constant.WEBDRIVER.getWindowHandles()) {
	    	Constant.WEBDRIVER.switchTo().window(handle);
	        if (Constant.WEBDRIVER.getTitle().equals(expectedTitle)) {
	            return;
	        }
	    }
	    throw new RuntimeException("Window with title not found: " + expectedTitle);
	}
	
	public static WebDriver newTab(String nameTab) {
		WebDriver webDriver = Constant.WEBDRIVER.switchTo().newWindow(WindowType.TAB);
		saveWindow(nameTab, webDriver);
		return webDriver;
	}
	
}
