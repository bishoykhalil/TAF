package zomato.gui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utils.BrowserActions;
import utils.ElementActions;
import utils.ExtentReport;
import utils.PropertiesReader;

public class Zomato_HomePage_Page {

    private WebDriver driver;
    private String zomatoUrl = PropertiesReader.getProperty("zomato.properties",
	    "zomato.homeUrl");

    // Constructor
    public Zomato_HomePage_Page(WebDriver driver) {
	this.driver = driver;
    }

    // Elements Locators
    
    private By acceptCookies_btn =By.xpath("//span[contains(text(),'Accept')]"); 
    private By searchForrestaurant_txt = By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']");
    private By restaurantName_p = By.xpath("//div[@class='sc-eMigcr coAkuy']");
    
    //////////////////////////// Actions ////////////////////////////
        

    public Zomato_HomePage_Page navigateToHomePage() {
	BrowserActions.navigateToUrl(driver, zomatoUrl);
	return this;
    }

    public Zomato_HomePage_Page dismissCookieBar() {
	ElementActions.click(driver, acceptCookies_btn);
	return this;
    }

    

    @Step("Enter search value")
    public Zomato_HomePage_Page enterSearchValue(String restaurantName) {
	ElementActions.type(driver, searchForrestaurant_txt, restaurantName, true);
	ElementActions.click(driver, searchForrestaurant_txt);
	return this;
    }
    
    @Step("Select search result")
    public Zomato_HomePage_Page selectSearchResult(String restaurantName) {
	ElementActions.click(driver, search_results(restaurantName));
	return this;
    }
    
    private By search_results(String restaurantName) {
   	return By.xpath("//div[2]/div[1]/div[2]/div[1]//p[contains(text(),'"+ restaurantName +"')]//parent::div[1]");
       }
    
    @Step("Get the text of restaurant Name")
    public String getrestaurantName() {
	return ElementActions.getText(driver,restaurantName_p );
    }
    
    
}
