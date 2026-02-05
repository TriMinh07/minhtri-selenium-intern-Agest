import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test2 {

	
	
	
	
	@Test
	private void publicv() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("google.com");
	}
	
	
	@BeforeClass
	private void publi() {
		// TODO Auto-generated method stub
		System.err.println("nvxc");
	}
}
