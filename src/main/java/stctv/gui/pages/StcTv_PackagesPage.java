package stctv.gui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.enums.stcTv.TVPackages;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.enums.stcTv.TVPackages.CLASSIC;

public class StcTv_PackagesPage {
    public <E> E on(Supplier<E> supplier) {
        return supplier.get();
    }

    @Step("Get package Name : {0}")
    public String  getPackageName(TVPackages pkg) {
        return  $(byText(pkg.getPackageName()))
                .should(Condition.visible , Duration.ofMillis(50000)).getText();
    }
    @Step("Get package price : {0}")
    public String getPackagePrice(TVPackages pkg) {
        String price;
        switch (pkg.getPackageName()){
            case "Lite" :
                price = $x("//div[@id='currency-lite']/./b").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            case "Classic" :
                price = $x("//div[@id='currency-classic']/./b").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            case "Premium" :
                price = $x("//div[@id='currency-premium']/./b").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pkg.getPackageName());
        }
        return price;
    }
    @Step("Get package currency : {0}")
    public String getPackageCurrency(TVPackages pkg) {
        String currency;
        switch (pkg.getPackageName()){
            case "Lite" :
                currency = $x("//div[@id='currency-lite']/./i").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            case "Classic" :
                currency = $x("//div[@id='currency-classic']/./i").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            case "Premium" :
                currency = $x("//div[@id='currency-premium']/./i").should(Condition.visible , Duration.ofMillis(50000)).getText();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pkg.getPackageName());
        }
        return Arrays.stream(currency.split("/")).findFirst().get();
    }

}
