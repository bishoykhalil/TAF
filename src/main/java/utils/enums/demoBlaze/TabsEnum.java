package utils.enums.demoBlaze;

import lombok.Getter;

public enum TabsEnum {

    SIGN_UP("Sign up"),
    LOGIN("Log in");
    @Getter
    private final String tabName;

    TabsEnum(String tabName) {
        this.tabName = tabName;
    }

    public static TabsEnum fromString(String value) {
        for (TabsEnum tab : TabsEnum.values())
            if (tab.tabName.equals(value)) return tab;

        throw new IllegalArgumentException(
                "The Tab input value: "
                        +value
                        +"is not correct. Should be something like:"
                        +TabsEnum.SIGN_UP.getTabName());
    }
}