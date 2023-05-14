package utils.enums.stcTv;

import lombok.Getter;

public enum TVPackages {

    NONE("None"),
    LITE("LITE"),
    CLASSIC("CLASSIC"),
    PREMIUM("PREMIUM");

    @Getter private final String packageType ;

    TVPackages(String packageType){
        this.packageType = packageType;
    }
    public static TVPackages fromString(String value) {
        for (TVPackages tvPackage : TVPackages.values())
            if (tvPackage.packageType.equals(value)) return tvPackage;
        throw new IllegalArgumentException(
                "The TV Package input value: "
                        +value
                        +"is not correct. Should be something like:"
                        + TVPackages.CLASSIC.getPackageType());
    }
}
