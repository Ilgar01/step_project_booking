package az.iktlab.enums;

public enum Operation {
    SHOW("1"),INFO("2"),BOOK("3"),CANCEL("4"),
    FLIGHTS("5"),EXIT("6");

    private final String shortName;

    Operation(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
