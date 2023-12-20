package utils.enums.stcTv;

import lombok.Getter;

public enum TVPackages {

    NONE("None","0","0","0"),
    LITE("Lite","15","2","1.2"),
    CLASSIC("Classic","25","3","2.5"),
    PREMIUM("Premium","60","6","4.8");

    @Getter private final String packageName ,ksaPrice,bahPrice,KuwPrice;

    TVPackages(String packageType,String ksaPrice,String bahPrice,String KuwPrice){
        this.packageName = packageType;
        this.ksaPrice = ksaPrice;
        this.bahPrice = bahPrice;
        this.KuwPrice = KuwPrice;
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
