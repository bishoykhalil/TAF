package stctv.gui.pages.Bulider;

import lombok.Builder;
import utils.enums.stcTv.Country;
import utils.enums.stcTv.Currency;
import utils.enums.stcTv.TVPackages;

@Builder
public class PackageBulider {
    @Builder.Default
    TVPackages tvPackage = TVPackages.NONE;
    @Builder.Default
    Country country = Country.NONE;
    @Builder.Default
    Currency currency = Currency.NONE;
    @Builder.Default int price = 0;
}
