package stcTv.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import stctv.gui.pages.StcTv_HomePage;
import stctv.gui.pages.StcTv_PackagesPage;
import utils.enums.stcTv.Country;
import utils.enums.stcTv.Currency;
import utils.enums.stcTv.TVPackages;

public class StcTv_Gui_ValidatePackages {

    Country country;
    TVPackages tvPackage;
    String price;
    Currency currency;
    @BeforeTest
    @Parameters({"Country" , "Package"})
    public void defineParameters(Country country,TVPackages tvPackage) {
        this.country = country;
        this.tvPackage = tvPackage;
        this.price = country == Country.KSA ? tvPackage.getKsaPrice() :
                country == Country.BAHRAIN ? tvPackage.getBahPrice() :
                        country == Country.KUWAIT ? tvPackage.getKuwPrice() : null;
        this.currency = country.equals(Country.KSA) ? Currency.SAR :
                country.equals(Country.BAHRAIN) ? Currency.BHD :
                        country.equals(Country.KUWAIT) ? Currency.KWD : null;
    }
    @Test
    public void stcTv_gui_ValidatePackages(){
        new StcTv_HomePage().navigateToHomePage().selectCountry(country);
        StcTv_PackagesPage packagesPage= new StcTv_PackagesPage();
        Assert.assertTrue(packagesPage.getPackageName(tvPackage).equalsIgnoreCase(tvPackage.getPackageName()));
        Assert.assertTrue(packagesPage.getPackagePrice(tvPackage).equalsIgnoreCase(price));
        Assert.assertTrue(packagesPage.getPackageCurrency(tvPackage).equalsIgnoreCase(currency.getCurrencyName()));
    }
}
