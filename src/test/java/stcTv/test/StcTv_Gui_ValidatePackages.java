package stcTv.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import stctv.gui.pages.StcTv_HomePage;
import stctv.gui.pages.StcTv_PackagesPage;
import utils.enums.stcTv.Country;
import utils.enums.stcTv.Currency;
import utils.enums.stcTv.TVPackages;

public class StcTv_Gui_ValidatePackages {


    @Test
    @Parameters({"Country" , "Package"})
    public void stcTv_gui_ValidatePackages( Country country,TVPackages tvPackage){
        new StcTv_HomePage().navigateToHomePage().selectCountry(country);
        StcTv_PackagesPage packagesPage= new StcTv_PackagesPage();
        Assert.assertTrue(packagesPage.getPackageName(tvPackage).equalsIgnoreCase(tvPackage.getPackageName()));
//        Assert.assertTrue(packagesPage.getPackagePrice(tvPackage).equalsIgnoreCase(tvPackage.getPrice()));
        Currency currency =  country.equals(Country.KSA) ? Currency.SAR :
                country.equals(Country.BAHRAIN) ? Currency.BHD :
                        country.equals(Country.KUWAIT) ? Currency.KWD : null;
        Assert.assertTrue(packagesPage.getPackageCurrency(TVPackages.CLASSIC).equalsIgnoreCase(currency.getCurrencyName()));
    }
}
