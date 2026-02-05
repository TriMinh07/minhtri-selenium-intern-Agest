package Railway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Constant.Constant;
import Common.Utilites;

public class test {
	
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();	
		driver.get("google.com");
	}
}
