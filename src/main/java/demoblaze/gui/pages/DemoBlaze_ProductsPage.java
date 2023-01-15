package demoblaze.gui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.AlertNotFoundException;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.*;

public class DemoBlaze_ProductsPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBlaze_SignUpPage.class);

    public <E> E on(Supplier<E> supplier){
        return supplier.get();
    }

    @Step("Check the listed Categories has items")
    public DemoBlaze_ProductsPage checkListedCategoriesHasItems(){
        $$x("");
        Assert.assertTrue($$x("//div[@id='tbodyid']").size() > 0);
        return page(this);
    }

    @Step("Add Item to the cart")
    public DemoBlaze_ProductsPage addFirstItemToCart(){
        $$x("//div[@id='tbodyid']").first().should(Condition.enabled).click();
        $x("//a[text()='Add to cart']").should(Condition.enabled).click();
        try{
            Alert alert= switchTo().alert();
            String alertMsg =alert.getText();
            if (alertMsg.contains("Product added."))alert.accept();
            Assert.assertEquals(alertMsg,"Product added.");
        }catch (AlertNotFoundException e){
            LOGGER.info("Alert not present , Product not added.");
        }
        return page(this);
    }
    @Step("Remove Item from Cart")
    public DemoBlaze_ProductsPage removeItemFromCart(){
        $x("//a[text()='Delete']").should(Condition.visible).click();
        return page(this);
    }

    @Step("check out")
    public DemoBlaze_ProductsPage checkOut(){
        $x("//button[text()='Place Order']").should(Condition.visible).click();
        $x("//input[@id='name']").setValue("name");
        $x("//input[@id='country']").setValue("Saudi Arabia");
        $x("//input[@id='city']").setValue("riyadh");
        $x("//input[@id='card']").setValue("123456789");
        $x("//input[@id='month']").setValue("1");
        $x("//input[@id='year']").setValue("2028");
        $x("//button[text()='Purchase']").click();
        $x("//h2[text()='Thank you for your purchase!']").should(Condition.visible, Duration.ofMillis(20000));
        Assert.assertTrue($x("//h2[text()='Thank you for your purchase!']").isDisplayed());
        return page(this);
    }
}
