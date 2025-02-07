package Model;

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

    @Override
    public String toString(){
        return brand + ", " + model + ", " + getUnitPriceString() + ", " + getRamString() + ", " +
                getScreenSizeString() + ", " + os + ", " + getScreenResolutionWidthString() + ", " +
                getScreenResolutionHeightString() + ", " + getProcessorCoresString() + ", " +
                getBatteryCapacityString() + ", " + getConnectivityString() + ", " + mobileStandard;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public int getRam() {
        return ram;
    }

    public String getRamString() {
        return ram + " GiB";
    }

    public void setRam(int ram) {
        this.ram = ram;
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

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
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

    public int getScreenResolutionHeight() {
        return screenResolutionHeight;
    }

    public String getScreenResolutionHeightString() {
        return screenResolutionHeight + " pixels height";
    }

    public void setScreenResolutionHeight(int screenResolutionHeight) {
        this.screenResolutionHeight = screenResolutionHeight;
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

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getBatteryCapacityString() {
        return batteryCapacity + " Wh";
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
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

    public MobileStandard getMobileStandard() {
        return mobileStandard;
    }

    public void setMobileStandard(MobileStandard mobileStandard) {
        this.mobileStandard = mobileStandard;
    }
}
