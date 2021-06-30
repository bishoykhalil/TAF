package zomato.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import utils.BrowserActions;
import utils.BrowserFactory;
import utils.ExcelFileManager;
import zomato.gui.pages.Zomato_HomePage_Page;

public class Gui_SearchForRestaurant_Test {

    private WebDriver driver;
    private ExcelFileManager spreadSheet;
    private String restaurantName;

    @BeforeClass
    public void setUp() {
	spreadSheet = new ExcelFileManager(
		new File("src/test/resources/TestData/Zomato_SearchForResutrant_TestData.xlsx"));
	spreadSheet.switchToSheet("GUI");
    }

    @BeforeMethod
    public void beforeMethod() {
	driver = BrowserFactory.getBrowser();
	new Zomato_HomePage_Page(driver).navigateToHomePage();
    }

    @Test(description = "ZOMATO - GUI - Validate Searching for Restaurant successfully")
    @Description("After Navigating to ZOMATO homepage, and search for restaurant name, then select the name from the search result, Restaurant page should be opened successfully  ")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")

    public void searchForRestaurantSuccessfully() {

	restaurantName=spreadSheet.getCellData("Resturant Name", 2);

	String restaurantNameafterSearch =  new Zomato_HomePage_Page(driver).
		dismissCookieBar().
		enterSearchValue(restaurantName).
		selectSearchResult(restaurantName).
		getrestaurantName();

	Assert.assertEquals(restaurantNameafterSearch,spreadSheet.getCellData("Expected Result", 2));
    }
    
    @AfterMethod
    public void afterMethod() {
	BrowserActions.closeAllOpenedBrowserWindows(driver);
    }

}
