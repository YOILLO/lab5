package lab5.data;

public enum Furnish {
    DESIGNER,
    FINE,
    BAD,
    LITTLE;

    public static String nameList() {
        String nameList = "";
        for (Furnish furnish : values()) {
            nameList += furnish.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
