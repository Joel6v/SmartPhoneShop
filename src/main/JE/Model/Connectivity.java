package Model;

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

    @Override
    public String toString() {
        return fullName;
    }
}
