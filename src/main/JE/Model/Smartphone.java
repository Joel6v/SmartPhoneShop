package Model;

import Model.Enum.Brand;
import Model.Enum.Connectivity;
import Model.Enum.MobileStandard;
import Model.Enum.Os;
import org.bson.Document;

import java.util.ArrayList;

public class Smartphone {
    private Brand brand;
    private String model;
    private double unitPrice; //[CHF]
    private int ram; //[GiB]
    private int screenSize; //[inch] diagonal
    private Os os;
    private int screenResolutionWidth; //pixels
    private int screenResolutionHeight; //pixels
    private int processorCores; //Number of physical cores of the CPU
    private int batteryCapacity; //[Wh]
    private ArrayList<Connectivity> connectivity;
    private MobileStandard mobileStandard;

    public Smartphone(Brand brand, String model, double unitPrice, int ram, int screenSize, Os os,
                      int screenResolutionWidth, int screenResolutionHeight, int processorCores,
                      int batteryCapacity, ArrayList<Connectivity> connectivity, MobileStandard mobileStandard) {
        this.brand = brand;
        this.model = model;
        this.unitPrice = unitPrice;
        this.ram = ram;
        this.screenSize = screenSize;
        this.os = os;
        this.screenResolutionWidth = screenResolutionWidth;
        this.screenResolutionHeight = screenResolutionHeight;
        this.processorCores = processorCores;
        this.batteryCapacity = batteryCapacity;
        this.connectivity = connectivity;
        this.mobileStandard = mobileStandard;
    }

    public Smartphone(){
        brand = Brand.APPLE;
        model = "";
        unitPrice = 0;
        ram = 0;
        screenSize = 0;
        os = Os.IOS;
        screenResolutionWidth = 0;
        screenResolutionHeight = 0;
        processorCores = 0;
        batteryCapacity = 0;
        connectivity = new ArrayList<>();
        mobileStandard = MobileStandard.G2;
    }

    public Smartphone(Document document){
        setBrand(document.getString("brand"));
        model = document.getString("model");
        unitPrice = document.getDouble("unitPrice");
        ram = document.getInteger("ram");
        screenSize = document.getInteger("screenSize");
        setOs(document.getString("os"));
        screenResolutionWidth = document.getInteger("screenResolutionWidth");
        screenResolutionHeight = document.getInteger("screenResolutionHeight");
        processorCores = document.getInteger("processorCores");
        batteryCapacity = document.getInteger("batteryCapacity");
        setConnectivity(document.getString("connectivity"));
        setMobileStandard(document.getString("mobileStandard"));
    }

    public Document toDocument(){
        return new Document("brand", brand.toString()).append("model", model).append("unitPrice", unitPrice).append("ram", ram)
                .append("screenSize", screenSize).append("os", os.toString()).append("screenResolutionWidth", screenResolutionWidth).
                append("screenResolutionHeight", screenResolutionHeight).append("processorCores", processorCores).
                append("batteryCapacity", batteryCapacity).append("connectivity", getConnectivityString()).append("mobileStandard", mobileStandard.toString());
    }

    @Override
    public String toString(){
        return "Hersteller: " + brand.toString() + "\nModel: " + model + "\nEinzelpreis: " + getUnitPriceString() + "\nRAM: " + getRamString() +
                "\nBildschimgrösse " + getScreenSizeString() + "\nBetriebssystem: " + os + "\nAuflösung breite: " + getScreenResolutionWidthString() +
                "\nAuflösung höhe: " + getScreenResolutionHeightString() + "\nProzessor: " + getProcessorCoresString() + "\nBatterie: " +
                getBatteryCapacityString() + "\nKonnektivität: " + getConnectivityString() + "\nMobilfunk Standart: " + mobileStandard;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setBrand(String brand){
        this.brand = Brand.convertFromString(brand);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceString() {
        return String.format("%.2f CHF", unitPrice);
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice(String unitPriceString) {
        this.unitPrice = Double.parseDouble(unitPriceString.substring(0, unitPriceString.indexOf(" CHF")));
    }

    public int getRam() {
        return ram;
    }

    public String getRamString() {
        return ram + " GiB";
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setRam(String ramString) {
        this.ram = Integer.parseInt(ramString.substring(0, ramString.indexOf(" GiB")));
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getScreenSizeString() {
        return screenSize + " inch";
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setScreenSize(String screenSizeString) {
        this.screenSize = Integer.parseInt(screenSizeString.substring(0, screenSizeString.indexOf(" inch")));
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public void setOs(String osString) {
        this.os = Os.convertFromString(osString);
    }

    public int getScreenResolutionWidth() {
        return screenResolutionWidth;
    }

    public String getScreenResolutionWidthString() {
        return screenResolutionWidth + " pixels width";
    }

    public void setScreenResolutionWidth(int screenResolutionWidth) {
        this.screenResolutionWidth = screenResolutionWidth;
    }

    public void setScreenResolutionWidth(String screenResolutionWidthString) {
        this.screenResolutionWidth = Integer.parseInt(screenResolutionWidthString.substring(0, screenResolutionWidthString.indexOf(" pixels width")));
    }

    public int getScreenResolutionHeight() {
        return screenResolutionHeight;
    }

    public String getScreenResolutionHeightString() {
        return screenResolutionHeight + " pixels height";
    }

    public void setScreenResolutionHeight(int screenResolutionHeight) {
        this.screenResolutionHeight = screenResolutionHeight;
    }

    public void setScreenResolutionHeight(String screenResolutionHeightString) {
        this.screenResolutionHeight = Integer.parseInt(screenResolutionHeightString.substring(0, screenResolutionHeightString.indexOf(" pixels height")));
    }

    public int getProcessorCores() {
        return processorCores;
    }

    public String getProcessorCoresString() {
        if(processorCores == 1){
            return "1 core";
        }else{
            return processorCores + " cores";
        }
    }

    public void setProcessorCores(int processorCores) {
        this.processorCores = processorCores;
    }

    public void setProcessorCores(String processorCoresString) {
        this.processorCores = Integer.parseInt(processorCoresString.substring(0, processorCoresString.indexOf(" core")));
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getBatteryCapacityString() {
        return batteryCapacity + " Wh";
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacityString) {
        this.batteryCapacity = Integer.parseInt(batteryCapacityString.substring(0, batteryCapacityString.indexOf(" Wh")));
    }

    public ArrayList<Connectivity> getConnectivity() {
        return connectivity;
    }

    public String getConnectivityString() {
        StringBuilder connectivityString = new StringBuilder();
        for (Connectivity connectivity : connectivity) {
            connectivityString.append(connectivity.toString()).append(", ");
        }

        return connectivityString.toString();
    }

    public void setConnectivity(ArrayList<Connectivity> connectivity) {
        this.connectivity = connectivity;
    }

    public void setConnectivity(String connectivityString) {
        String[] connectivitySplit = connectivityString.split(", ");
        ArrayList<Connectivity> connectivityList = new ArrayList<>(); //if an error occurs that the old list remains saved
        for(String str : connectivitySplit){
            connectivityList.add(Connectivity.convertFromString(str));
        }
        this.connectivity = connectivityList;
    }

    public MobileStandard getMobileStandard() {
        return mobileStandard;
    }

    public void setMobileStandard(MobileStandard mobileStandard) {
        this.mobileStandard = mobileStandard;
    }

    public void setMobileStandard(String mobileStandardString) {
        this.mobileStandard = MobileStandard.convertFromString(mobileStandardString);
    }
}
