package utils;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserActions {
    static WebDriver driver;

    public enum ConfirmAlertType {
	ACCEPT, DISMISS;
    }

    public enum CookieBuilderType {
	ADD, DELETE;
    }

//    @Step("Navigate to URL: [{url}]")
    public static void navigateToUrl(WebDriver driver, String url) {
	try {
	    LoggerClass.logStep("[Browser Action] Navigate to URL [" + url + "]");
	    driver.get(url);
	    ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	} catch (Exception e) {
	    LoggerClass.logStep(e.getMessage());
	    fail(e.getMessage());
	}
    }

//    @Step("Close All Opened Browser Windows.....")
    public static void closeAllOpenedBrowserWindows(WebDriver driver) {
	LoggerClass.logStep("[Browser Action] Close all Opened Browser Windows");
	if (driver != null) {
	    try {
		driver.quit();
	    } catch (WebDriverException rootCauseException) {
		LoggerClass.logMessage(rootCauseException.getMessage());
	    } finally {
		driver = null;
	    }
	} else {
	    LoggerClass.logMessage("Windows are already closed and the driver object is null.");
	}
    }

//    @Step("Maximize the Browser Window")
    public static void maximizeWindow(WebDriver driver) {
	try {
	    LoggerClass.logStep("[Browser Action] Maximize the Browser Window");
	    driver.manage().window().maximize();
	} catch (Exception e) {
	    LoggerClass.logMessage(e.getMessage());
	}
    }

    public static void confirmAlert(WebDriver driver, ConfirmAlertType confirmAlerType) {
	Helper.getExplicitWait(driver).until(ExpectedConditions.alertIsPresent());
	Alert alert = driver.switchTo().alert();
	switch (confirmAlerType) {
	case ACCEPT:
	    alert.accept();
	    break;
	case DISMISS:
	    Helper.getExplicitWait(driver).until(ExpectedConditions.alertIsPresent());
	    alert.dismiss();
	    break;
	}
    }

    public static void cookieBuilder(WebDriver driver, CookieBuilderType cookieBuilderType, String name, String value,
	    String domain) {
	Cookie cookie = new Cookie.Builder(name, value).domain(domain).build();

	switch (cookieBuilderType) {
	case ADD:
	    driver.manage().addCookie(cookie);
	    break;
	case DELETE:
	    driver.manage().deleteCookie(cookie);
	    break;
	}
    }

}
