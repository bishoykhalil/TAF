package utils.enums.stcTv;

import lombok.Getter;

public enum TVPackages {

    NONE("None","0"),
    LITE("Lite","15"),
    CLASSIC("Classic","25"),
    PREMIUM("Premium","60");

    @Getter private final String packageName ,price;

    TVPackages(String packageType,String price){
        this.packageName = packageType;
        this.price = price;
    }
    public static TVPackages fromString(String value) {
        for (TVPackages tvPackage : TVPackages.values())
            if (tvPackage.packageName.equals(value)) return tvPackage;
        throw new IllegalArgumentException(
                "The TV Package input value: "
                        +value
                        +"is not correct. Should be something like:"
                        + TVPackages.CLASSIC.getPackageName());
    }
}
