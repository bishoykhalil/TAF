package demoBlaze.tests;

import demoblaze.gui.pages.DemoBlaze_HomePage;
import demoblaze.gui.pages.DemoBlaze_LoginPage;
import demoblaze.gui.pages.DemoBlaze_ProductsPage;
import demoblaze.gui.pages.DemoBlaze_SignUpPage;
import org.testng.annotations.*;
import utils.enums.demoBlaze.TabsEnum;
import static com.codeborne.selenide.Selenide.closeWebDriver;
public class Gui_CreateUserAndAddProducts {

    private String username,password;
    private Boolean checkItems;
    private Boolean addItem;
    private Boolean removeItem;
    private Boolean checkOut ;

    @BeforeTest
    @Parameters({
            "Username",
            "Password",
            "CheckItems",
            "AddItem",
            "RemoveItem",
            "CheckOut"
    })
    public void defineDefaultParams(
            @Optional String username,
            @Optional String password,
            @Optional Boolean checkItems,
            @Optional Boolean addItem,
            @Optional Boolean removeItem,
            @Optional Boolean checkOut){

        this.username = username != null ? username : "QPROS"+java.time.LocalTime.now();
        this.password= password != null ? password : "123";
        this.checkItems = checkItems != null ? checkItems : false ;
        this.addItem = addItem != null ? addItem : false ;
        this.removeItem = removeItem != null ? removeItem : false ;
        this.checkOut = checkOut != null ? checkOut : false ;
    }
    @Test
    public void gui_createUserAndHandleProducts(){
        DemoBlaze_HomePage homePage = new DemoBlaze_HomePage();
        homePage.navigateToHomePage()
                .selectTabWithName(TabsEnum.SIGN_UP)
                .on(DemoBlaze_SignUpPage::new)
                .signUp(username,password)
                .on(DemoBlaze_HomePage::new)
                .selectTabWithName(TabsEnum.LOGIN)
                .on(DemoBlaze_LoginPage::new)
                .login(username,password);
        DemoBlaze_ProductsPage productsPage = new DemoBlaze_ProductsPage();
        if (checkItems) productsPage.checkListedCategoriesHasItems();
        if(addItem)productsPage.addFirstItemToCart();
        if(removeItem){
            homePage.selectTabWithName(TabsEnum.CART)
                    .on(DemoBlaze_ProductsPage::new).removeItemFromCart();
        }
        if(checkOut){
            homePage.selectTabWithName(TabsEnum.CART)
                    .on(DemoBlaze_ProductsPage::new).checkOut();}
    }
    @AfterTest
    public void tearDown(){
    closeWebDriver();
    }
}
