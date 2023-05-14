package utils.enums.stcTv;

import lombok.Getter;

public enum Country {

    NONE("None"),
    KSA("KSA"),
    BAHRAIN("Bahrain"),
    KUWAIT("Kuwait");

    @Getter private final String countryName ;

    Country(String countryName){
        this.countryName = countryName;
    }
    public static Country fromString(String value) {
        for (Country country : Country.values())
            if (country.countryName.equals(value)) return country;
        throw new IllegalArgumentException(
                "The TV Package input value: "
                        +value
                        +"is not correct. Should be something like:"
                        + Country.BAHRAIN.getCountryName());
    }
}
