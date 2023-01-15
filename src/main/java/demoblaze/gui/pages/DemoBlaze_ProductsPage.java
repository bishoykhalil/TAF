package demoblaze.gui.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;

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
//        try {
//            Thread.sleep(500000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return page(this);
    }
}
