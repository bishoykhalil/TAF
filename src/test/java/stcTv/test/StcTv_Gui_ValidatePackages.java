package stcTv.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import stctv.gui.Bulider.PackageBulider;
import stctv.gui.pages.StcTv_HomePage;
import stctv.gui.pages.StcTv_PackagesPage;
import utils.enums.stcTv.Country;
import utils.enums.stcTv.TVPackages;

public class StcTv_Gui_ValidatePackages {


    @Test
    public void stcTv_gui_ValidatePackages(){
        new StcTv_HomePage().navigateToHomePage().selectCountry(Country.fromString("KSA"));
        StcTv_PackagesPage packagesPage= new StcTv_PackagesPage();
        Assert.assertTrue(packagesPage.getPackageName(TVPackages.CLASSIC).equalsIgnoreCase(TVPackages.CLASSIC.getPackageName()));
        Assert.assertTrue(packagesPage.getPackagePrice(TVPackages.CLASSIC).equalsIgnoreCase(TVPackages.CLASSIC.getPrice()));
        //Assert.assertTrue(packagesPage.getPackageCurrency(TVPackages.CLASSIC).equalsIgnoreCase(TVPackages.CLASSIC.getPackageName()));
    }
}
