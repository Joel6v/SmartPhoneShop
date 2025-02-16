package Model;

import Controller.MainController;
import org.bson.Document;

public class OrderPosition {
    private Smartphone orderedSmartphone;
    private int orderedUnitPrice;
    private int orderedQuantity;

    public OrderPosition(Smartphone orderedSmartphone, int orderedUnitPrice, int orderedQuantity) {
        this.orderedSmartphone = orderedSmartphone;
        this.orderedUnitPrice = orderedUnitPrice;
        this.orderedQuantity = orderedQuantity;
    }

    public OrderPosition(){
        orderedSmartphone = MainController.smartphone.getElement(0);
        orderedUnitPrice = 0;
        orderedQuantity = 0;
    }

    public OrderPosition(Document document) {
        orderedSmartphone = MainController.smartphone.getElement(document.getInteger("orderedSmartphone"));
        orderedUnitPrice = document.getInteger("orderedUnitPrice");
        orderedQuantity = document.getInteger("orderedQuantity");
    }

    public Document toDocument(){
        return new Document("orderedSmartphone", MainController.smartphone.getIndexElement(orderedSmartphone)).
                append("orderedUnitPrice", orderedUnitPrice).append("orderedQuantity", orderedQuantity);
    }

    @Override
    public String toString(){
        return "Bestelltes Smartphone: " + orderedSmartphone + "\nEinzelpreis: " + orderedUnitPrice + "\nAnzahl: " + orderedQuantity;
    }

    public Smartphone getOrderedSmartphone() {
        return orderedSmartphone;
    }

    public void setOrderedSmartphone(Smartphone orderedSmartphone) {
        this.orderedSmartphone = orderedSmartphone;
    }

    public int getOrderedUnitPrice() {
        return orderedUnitPrice;
    }

    public void setOrderedUnitPrice(int orderedUnitPrice) {
        this.orderedUnitPrice = orderedUnitPrice;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }
}
