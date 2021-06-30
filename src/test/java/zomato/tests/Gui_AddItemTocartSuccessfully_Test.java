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
import zomato.gui.pages.Zomato_Restaurant_Page;

public class Gui_AddItemTocartSuccessfully_Test {

    private WebDriver driver;
    private ExcelFileManager spreadSheet;
    private String restaurantName,foodName;

    @BeforeClass
    public void setUp() {
	spreadSheet = new ExcelFileManager(
		new File("src/test/resources/TestData/Zomato_addItemToCart_TestData.xlsx"));
	spreadSheet.switchToSheet("GUI");
		
    }

    @BeforeMethod
    public void beforeMethod() {
	driver = BrowserFactory.getBrowser();
	new Zomato_HomePage_Page(driver).navigateToHomePage();
    }



    @Test(description = "ZOMATO - GUI - validate aading item to cart successfully")
    @Description("when selecting a Restaurant name from the search result, then select orderOnline  , and place an order, the order selected should be placed in the cart")
    @Story("Sign Up")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")


    public void addItemToCartSuccessfully() {

	restaurantName=spreadSheet.getCellData("Resturant Name", 2);

	String restaurantNameafterSearch =  new Zomato_HomePage_Page(driver).
		dismissCookieBar().
		enterSearchValue(restaurantName).
		selectSearchResult(restaurantName).
		getrestaurantName();

	Assert.assertEquals(restaurantNameafterSearch,spreadSheet.getCellData("Expected Result1", 2));

	foodName=spreadSheet.getCellData("Item Name", 2);
	
	String searchFood_rst = new Zomato_Restaurant_Page(driver).
		clickOnOrderOnline().
		searchMenu(foodName).
		getfoodSearchName();

	Assert.assertEquals(searchFood_rst,spreadSheet.getCellData("Expected Result2", 2));

	String foodNameInCart =new Zomato_Restaurant_Page(driver).
		clickOnaddBtn().
		clickOnaddtoOrderBtn().
		clickOnOpenCart().
		getFoodNameFromCart();

	Assert.assertEquals(foodNameInCart,spreadSheet.getCellData("Expected Result2", 2));
    }

    @AfterMethod
    public void afterMethod() {
	BrowserActions.closeAllOpenedBrowserWindows(driver);
    }
}
