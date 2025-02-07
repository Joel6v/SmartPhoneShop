package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Order {
    private byte[] orderNumber;
    private LocalDateTime orderDate;
    private Customer orderedByCustomer;
    private ArrayList<Smartphone> orderedSmartphones;
    private double totalPrice;

    public Order(byte[] orderNumber, LocalDateTime orderDate, Customer orderedByCustomer,
                 ArrayList<Smartphone> orderedSmartphones, double totalPrice) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderedByCustomer = orderedByCustomer;
        this.orderedSmartphones = orderedSmartphones;
        this.totalPrice = totalPrice;
    }

    public Order(LocalDateTime orderDate, Customer orderedByCustomer, ArrayList<Smartphone> orderedSmartphones, double totalPrice) {
        this.orderDate = orderDate;
        this.orderedByCustomer = orderedByCustomer;
        this.orderedSmartphones = orderedSmartphones;
        this.totalPrice = totalPrice;
    }

    public byte[] getOrderNumber() {
        return orderNumber;
    }

    public String getOrderNumberHex(){
        StringBuilder sb = new StringBuilder();
        for (byte b : orderNumber) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public void setOrderNumber(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); //128 bit = 16 byte = 32 hex

            String input = getOrderDateString() + orderedByCustomer + getOrderedSmartphonesString() + getTotalPriceString();
            md.update(input.getBytes());
            orderNumber = Arrays.copyOf(md.digest(), 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getOrderDateString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return orderDate.format(formatter);
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getOrderedByCustomer() {
        return orderedByCustomer;
    }

    public void setOrderedByCustomer(Customer orderedByCustomer) {
        this.orderedByCustomer = orderedByCustomer;
    }

    public ArrayList<Smartphone> getOrderedSmartphones() {
        return orderedSmartphones;
    }

    public String getOrderedSmartphonesString(){
        StringBuilder sb = new StringBuilder();
        for (Smartphone sm : orderedSmartphones) {
            sb.append(sm.toString()).append(", ");
        }
        return sb.toString();
    }

    public void setOrderedSmartphones(ArrayList<Smartphone> orderedSmartphones) {
        this.orderedSmartphones = orderedSmartphones;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getTotalPriceString(){
        return String.format("%.2f CHF", totalPrice);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
