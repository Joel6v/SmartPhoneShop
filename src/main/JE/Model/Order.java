package Model;

import Controller.MainController;
import org.bson.Document;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private byte[] orderNumber;
    private LocalDateTime orderDate;
    private Address shippingAddress;
    private Customer orderedByCustomer;
    private ArrayList<OrderPosition> orderPositions;
    private double totalPrice;

    public Order(byte[] orderNumber, LocalDateTime orderDate, Address shippingAddress, Customer orderedByCustomer,
                 ArrayList<OrderPosition> orderPositions, double totalPrice) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderedByCustomer = orderedByCustomer;
        this.orderPositions = orderPositions;
        this.totalPrice = totalPrice;
    }

    public Order(LocalDateTime orderDate, Address shippingAddress, Customer orderedByCustomer, ArrayList<OrderPosition> orderPositions, double totalPrice) {
        setOrderNumber();
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderedByCustomer = orderedByCustomer;
        this.orderPositions = orderPositions;
        this.totalPrice = totalPrice;
    }

    public Order(){}

    public Order(Document document){
        setOrderNumber(document.getString("orderNumber"));
        setOrderDate(document.getString("orderDate"));
        shippingAddress = MainController.address.getElement(document.getInteger("shippingAddress"));
        orderedByCustomer = MainController.customer.getElement(document.getInteger("orderedByCustomer"));
        ArrayList<Integer> orderPositionId = (ArrayList<Integer>) document.get("orderPositions");
        orderPositions = MainController.orderPosition.getElement(orderPositionId);
        totalPrice = document.getDouble("totalPrice");
    }

    public Document toDocument(){
        return new Document("orderNumber", getOrderNumberHex()).append("orderDate", getOrderDateString()).
                append("shippingAddress", MainController.address.getIndexElement(shippingAddress)).append("orderedByCustomer", MainController.customer.getIndexElement(orderedByCustomer)).
                append("orderPositions", MainController.orderPosition.getIndexElement(orderPositions)).append("totalPrice", totalPrice);
    }

    @Override
    public String toString() {
        return "Bestellnummer: " + getOrderNumberHex() + "\nBestelldatum: " + getOrderDate() +
                "\nLieferadresse: " + getShippingAddress() + "\nKunde: " + "\nBestellpositionen: " +
                getOrderPositionsString() + "\nPreis Total: " + getTotalPriceString();
    }

    public byte[] getOrderNumber() {
        return orderNumber;
    }

    public String getOrderNumberHex(){
        StringBuilder hexString = new StringBuilder();
        for (byte b : orderNumber) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public void setOrderNumber(String hex) {
        for (int i = 0; i < 16; i++) {
            orderNumber[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
    }

    public void setOrderNumber(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); //128 bit = 16 byte = 32 hex

            String input = getOrderDateString() + " " + orderedByCustomer + " " + shippingAddress + " " + getOrderPositionsString() + " " + getTotalPriceString();
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
        return LocalDateFormatter.convertToString(orderDate);
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderDate(String orderDateString){
        orderDate = LocalDateFormatter.convertStringToDateTime(orderDateString);
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Customer getOrderedByCustomer() {
        return orderedByCustomer;
    }

    public void setOrderedByCustomer(Customer orderedByCustomer) {
        this.orderedByCustomer = orderedByCustomer;
    }

    public ArrayList<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public String getOrderPositionsString(){
        StringBuilder sb = new StringBuilder();
        for (OrderPosition op : orderPositions) {
            sb.append(op.toString()).append(", ");
        }
        return sb.toString();
    }

    public void setOrderPositions(ArrayList<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
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

    public void setTotalPrice(String totalPriceString){
        totalPrice = Double.parseDouble(totalPriceString.substring(0, totalPriceString.indexOf(" CHF")));
    }
}
