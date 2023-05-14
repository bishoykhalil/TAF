package utils.enums.stcTv;

import lombok.Getter;

public enum Currency {

    NONE("None"),
    BHD("BHD"),
    SAR("SAR"),
    KWD("KWD");

    @Getter private final String currencyName ;

    Currency(String currencyName){
        this.currencyName = currencyName;
    }
    public static Currency fromString(String value) {
        for (Currency currency : Currency.values())
            if (currency.currencyName.equals(value)) return currency;
        throw new IllegalArgumentException(
                "The TV Package input value: "
                        +value
                        +"is not correct. Should be something like:"
                        + Currency.SAR.getCurrencyName());
    }
}
