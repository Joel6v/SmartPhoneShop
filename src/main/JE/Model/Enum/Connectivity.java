package Model.Enum;

public enum Connectivity {
    BLUETOOTH ("Bluetooth"),
    NFC ("NFC"),
    UBS_C ("UBS-C"),
    MICRO_USB_B ("Micro-USB-B"),
    WIFI_HOTSPOT ("Wifi-Hotspot"),
    WLAN ("WLAN");

    private final String fullName;

    Connectivity(String fullName) {
        this.fullName = fullName;
    }

    public static Connectivity convertFromString(String str){
        for(Connectivity connectivity : Connectivity.values()){
            if(connectivity.fullName.equals(str)){
                return connectivity;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
