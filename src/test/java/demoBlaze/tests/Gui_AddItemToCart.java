package demoBlaze.tests;

import demoblaze.gui.pages.DemoBlaze_HomePage;
import demoblaze.gui.pages.DemoBlaze_LoginPage;
import demoblaze.gui.pages.DemoBlaze_ProductsPage;
import demoblaze.gui.pages.DemoBlaze_SignUpPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.enums.demoBlaze.TabsEnum;

import static com.codeborne.selenide.Selenide.open;

public class Gui_AddItemToCart {

    private String username="%789%_20";
    @Test
    public void addItemToCart(){
        new DemoBlaze_HomePage()
                .navigateToHomePage()
                .selectTabWithName(TabsEnum.SIGN_UP)
                .on(DemoBlaze_SignUpPage::new)
                .signUp(username,"123")
                .on(DemoBlaze_HomePage::new)
                .selectTabWithName(TabsEnum.LOGIN)
                .on(DemoBlaze_LoginPage::new)
                .login(username,"123")
                .on(DemoBlaze_ProductsPage::new)
                .checkListedCategoriesHasItems()
                .addFirstItemToCart();
    }

}
