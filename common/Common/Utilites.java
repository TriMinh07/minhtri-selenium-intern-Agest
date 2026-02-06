package Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import net.bytebuddy.asm.Advice.This;

public class Utilites {
	
	public static WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIME_SYSTEMOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public static WebElement waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIME_SYSTEMOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
	
	public static boolean isElementInvisible(By locator) {
	        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIME_SYSTEMOUT));
	        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	
	
}
