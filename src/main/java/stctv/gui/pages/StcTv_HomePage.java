package stctv.gui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesReader;
import utils.enums.stcTv.Country;

import java.time.Duration;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.*;

public class StcTv_HomePage {

    final private String stcTvUrl= PropertiesReader.getProperty("stctv.properties",
            "stctv.homeUrl");

    final SelenideElement countryTab =$x("//div[@id='country-selct']");
    public <E> E on(Supplier<E> supplier) {
        return supplier.get();
    }

    @Step("Navigate to STC-Tv home page")
    public StcTv_HomePage navigateToHomePage() {
        Configuration.browser = "edge";
        open(stcTvUrl);
        return page(this);
    }

    @Step("Select country : {0}")
    public StcTv_HomePage selectCountry(Country country) {
        $(By.id("country-btn")).should(Condition.enabled , Duration.ofMillis(20000)).click();
        $x("//div[@id='country-selct']//span[contains(text(),'"+country.getCountryName()+"')]").
        should(Condition.enabled , Duration.ofMillis(50000)).click();
        return page(this);
    }

}
