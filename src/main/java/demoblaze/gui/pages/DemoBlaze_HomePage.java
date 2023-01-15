package demoblaze.gui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.PropertiesReader;
import utils.enums.demoBlaze.TabsEnum;

import java.time.Duration;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.*;

public class DemoBlaze_HomePage {
    final private String demoBlazeUrl = PropertiesReader.getProperty("demoBlaze.properties",
            "demoBlaze.homeUrl");
    final SelenideElement tabs = $x("//div[@id='navbarExample']//ancestor::ul");

    public <E> E on(Supplier<E> supplier){
        return supplier.get();
    }

    @Step("Navigate to home page")
    public DemoBlaze_HomePage navigateToHomePage(){
       System.out.println("URL Is : "+demoBlazeUrl);
        open(demoBlazeUrl);
        return page(this);
    }

    @Step("Select Home Tab : {0}")
    public DemoBlaze_HomePage selectTabWithName(TabsEnum tab){
        tabs.$x(".//a[text()='"+tab.getTabName()+"']")
                .should(Condition.enabled, Duration.ofMillis(20000))
                .click();
        return page(this);
    }
}
