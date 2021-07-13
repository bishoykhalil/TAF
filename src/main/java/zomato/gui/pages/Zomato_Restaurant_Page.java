package zomato.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import utils.ElementActions;

public class Zomato_Restaurant_Page {

    private WebDriver driver;

    // Constructor
    public Zomato_Restaurant_Page(WebDriver driver) {
   	this.driver = driver;
       }

    // Elements Locators
    private By orderOnline_Btn = By.xpath("//a[normalize-space()='Order Online']");
    private By searchMenuBox_txt = By.xpath("//input[@type='text']");
    private By foodSearchResult_str = By.xpath("//div[@class='sc-1s0saks-10 cYSFTJ']//h4[@class='sc-1s0saks-15 iSmBPS']");
    private By addToCart_Btn = By.xpath("//div[@class='sc-1s0saks-11 cYGeYt']//span[@class='sc-1usozeh-6 fTsfFl']");
    private By addToOrder_Btn = By.xpath("//span[@class='sc-1kx5g6g-2 ltILy']");
    private By openCart_btn = By.xpath("//div[1]/span[1]/i[1]/*[local-name()='svg'][1]");
    private By foodNameInCart_p = By.xpath("//div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//ancestor::p");
  
    
    
    /////////////////////Actions//////////////////////////
  

    @Step("Click on Order Online Btn")
    public Zomato_Restaurant_Page clickOnOrderOnline() {
	ElementActions.click(driver, orderOnline_Btn);
	return this ;
    }

    @Step("Search within menue in Order Online Page")
    public Zomato_Restaurant_Page searchMenu(String foodName) {
	ElementActions.type(driver, searchMenuBox_txt, foodName);
	return this ;
    }
          
    @Step("Get the text of food Search")
    public String getfoodSearchName() {
	return ElementActions.getText(driver, foodSearchResult_str);
    }
    
    @Step("Click on Add to cart Btn")
    public Zomato_Restaurant_Page clickOnaddBtn() {
	 ElementActions.click(driver, addToCart_Btn);
	 return this ;
    }
    
    @Step("confirm to add Order")
    public Zomato_Restaurant_Page clickOnaddtoOrderBtn() {
	 ElementActions.click(driver, addToOrder_Btn);
	 return this ;
    }
    
    @Step("Click on open cart")
    public Zomato_Restaurant_Page clickOnOpenCart() {
	 ElementActions.click(driver, openCart_btn);
	 return this ;
    }
    
    @Step("Get the text of Resturant Name")
    public String getFoodNameFromCart() {
	return ElementActions.getText(driver,foodNameInCart_p );
    }
}
