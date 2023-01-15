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
import static com.codeborne.selenide.Selenide.page;

public class DemoBlaze_LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBlaze_SignUpPage.class);

    public <E> E on(Supplier<E> supplier){
        return supplier.get();
    }

    @Step("Enter Username : {0}")
    private DemoBlaze_LoginPage enterUsername(String username){
        $x("//input[@id='loginusername']")
                .should(Condition.visible, Duration.ofMillis(20000))
                .setValue(username);
        return page(this);
    }

    @Step("Enter Password")
    private DemoBlaze_LoginPage enterPassword(String password){
        $x("//input[@id='loginpassword']")
                .should(Condition.visible, Duration.ofMillis(20000))
                .setValue(password);
        return page(this);
    }

    @Step("Press Sign Up")
    public DemoBlaze_LoginPage pressLogin(){
        $x("//button[text()='Log in']")
                .should(Condition.enabled, Duration.ofMillis(20000))
                .click();
        return page(this);
    }

    @Step("Sign Up")
    public DemoBlaze_LoginPage login(String username , String password){
        enterUsername(username).enterPassword(password).pressLogin();
        $x("//a[text()='Log out']").should(Condition.visible , Duration.ofMillis(20000));
        Assert.assertTrue($x("//a[text()='Log out']").isDisplayed());
        String msg = String.format("login done using %s.",username);
        LOGGER.info(msg);
    return page(this);
    }
}
