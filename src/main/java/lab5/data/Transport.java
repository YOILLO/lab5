package lab5.data;

public enum Transport {
    LITTLE,
    NORMAL,
    ENOUGH;

    public static String nameList() {
        String nameList = "";
        for (Transport transport : values()) {
            nameList += transport.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
