package Common;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import net.bytebuddy.asm.Advice.This;

public class Utilities {
	
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
	
	public static WebElement waitForVisible(By locator, int timeoutSeconds) {
    	WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void click(By locator) {
    	waitForVisible(locator, 12);
    	scrollToElement(getElement(locator));
        waitForClickable(locator);
        getElement(locator).click();
    }

    public static void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        return waitForVisible(locator).getText();
    }
    
    public static String getArtribute(By locator, String nameArtribute) {
        return waitForVisible(locator).getAttribute(nameArtribute);
    }


    public static WebElement getElement(By locator) {
        return waitForVisible(locator);
    }

    public static List<WebElement> getElements(By locator) {
        return Constant.WEBDRIVER.findElements(locator);
    }

    public static WebElement getElementFrom(WebElement parent, By childLocator) {
        return parent.findElement(childLocator);
    }

    public static List<WebElement> getElementsFrom(WebElement parent, By childLocator) {
        return parent.findElements(childLocator);
    }
    
    public static boolean isDisplayElement(By locator) {
        try {
            return Constant.WEBDRIVER.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean waitForTextPresent(By locator, String expectedText, int timeoutSeconds) {
    	WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeoutSeconds));
	
	
	return wait.until(ExpectedConditions.textToBePresentInElementLocated(
            locator, expectedText
        ));
    }

    public static void clearAndType(WebElement element, String content) {
        element.clear();               
        element.sendKeys(content);
    }
    
    public static void clearAndType(By locator, String content) {
		WebElement element = waitForVisible(locator);
		element.clear();
		element.sendKeys(content);
	}
    
    public static void clearElement(WebElement element) {
		element.clear();
    }
    
    public static void refreshWindow() {
		Constant.WEBDRIVER.navigate().refresh();
	}
    
    public static void getUrl(String url) {
    	Constant.WEBDRIVER.get(url);
    }
    
    public static void clickByJS(By locator) {
    	Utilities.waitForVisible(locator, 20);
    	WebElement element = getElement(locator);
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) Constant.WEBDRIVER;
    	jsExecutor.executeScript("arguments[0].click();", element);
    }
    
    public static Select getSelectElement(By locator) {
    	WebElement selectElement = getElement(locator);
    	scrollToElement(selectElement);
    	return new Select(selectElement);
    }
    
    public static void waitForSelectOptionsReload(By locator) {
    	WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIME_SYSTEMOUT));
    	wait.until(driver -> {
    		WebElement selectElement = driver.findElement(locator);
    		return new Select(selectElement).getOptions().size() > 1;
    	});
    }
    
    
    public static void selectByText(Select select, String text) {
    	select.selectByVisibleText(text);
    }
    
    public static void selectByValue(Select select, String value) {
    	select.selectByValue(value);
    }
    
    public static void selectByContainsText(Select select, String text) {
    	select.selectByContainsVisibleText(text);
    }
    
    public static void selectByIndex(Select select, int index) {
    	select.selectByIndex(index);
    }
    
    public static void safeSelectByText(By selectBy, String text) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));

        wait.until(driver -> {
            try {
                WebElement selectEl = driver.findElement(selectBy);
                Select select = new Select(selectEl);
                select.selectByVisibleText(text);
                return true;
            } catch (StaleElementReferenceException e) {
                return false; // retry
            }
        });
    }
    
    public static WebElement waitForElementWithRefresh(By locator, int timeoutInSeconds, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeoutInSeconds));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                attempts++;
                System.out.println("Thử lại lần " + attempts + ": Refresh trang vì không tìm thấy " + locator.toString());
                Constant.WEBDRIVER.navigate().refresh();
                hardWait(3); 
            }
        }
        throw new RuntimeException("LỖI: Đã thử " + maxRetries + " lần nhưng vẫn không thấy phần tử: " + locator.toString());
    }

    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
