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

public class DemoBlaze_SignUpPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoBlaze_SignUpPage.class);

    public <E> E on(Supplier<E> supplier){
        return supplier.get();
    }
    @Step("Enter Username : {0}")
    private DemoBlaze_SignUpPage enterUsername(String username){
        $x("//input[@id='sign-username']")
                .should(Condition.visible, Duration.ofMillis(20000))
                .setValue(username);
        return page(this);
    }

    @Step("Enter Password")
    private DemoBlaze_SignUpPage enterPassword(String password){
        $x("//input[@id='sign-password']")
                .should(Condition.visible, Duration.ofMillis(20000))
                .setValue(password);
        return page(this);
    }

    @Step("Press Sign Up")
    public DemoBlaze_SignUpPage pressSignUp(){
        $x("//button[text()='Sign up']")
                .should(Condition.enabled, Duration.ofMillis(20000))
                .click();
        return page(this);
    }

    @Step("Sign Up")
    public DemoBlaze_SignUpPage signUp(String username , String password){
        enterUsername(username).enterPassword(password).pressSignUp();
        try{
            Alert alert= switchTo().alert();
            String alertMsg =alert.getText();
            if (alertMsg.contains("Sign up successful"))alert.accept();
            else LOGGER.info("Sign up Failed , Check alert message :"+alert.getText());
            Assert.assertEquals(alertMsg,"Sign up successful.");
        }catch (AlertNotFoundException e){
            LOGGER.info("Alert not present , SignUp Failed ");
        }
        return page(this);
    }
}
