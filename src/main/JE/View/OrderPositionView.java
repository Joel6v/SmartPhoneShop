package View;

import Controller.MainController;
import Model.Order;
import Model.OrderPosition;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderPositionView implements ISubMenu {
    private boolean closeMenu = false;
    @Override
    public void startViewLoop() {
        while(!closeMenu) {
            showSubMenu();
            selectSubMain();
        }
    }

    @Override
    public void showSubMenu() {
        System.out.println("+++++++++++++++");
        System.out.println("Bestellpositionen");
        System.out.println();
        System.out.println("[1] Hinzufügen");
        System.out.println("[2] Anzeigen alle");
        System.out.println("[3] Anzeigen mit Index");
        System.out.println("[4] Bearbeiten");
        System.out.println("[5] Löschen");
        System.out.println("[s] Speichern");
        System.out.println("[e] Zurück");
    }

    @Override
    public void selectSubMain() {
        System.out.print("Auswahl: ");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        switch(selection){
            case "1":{
                OrderPosition orderPosition = showElementInput();
                MainController.orderPosition.setElement(orderPosition);
            }break;
            case "2":{
                showElement();
            }break;
            case "3":{
                showElementIndex();
            }break;
            case "4":{
                updateElement();
            }break;
            case "5":{
                deleteElement();
            }break;
            case "s":{
                MainController.orderPosition.save();
            }break;
            case "e": {
                closeMenu = true;
            }break;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    public OrderPosition showElementInput(){
        OrderPosition orderPosition = new OrderPosition();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Eingabe");
        System.out.println();

        System.out.println("Smartphone [1]: ");
        orderPosition.setOrderedSmartphone(MainController.smartphone.getElement(Integer.parseInt(input.nextLine())));
        System.out.println("Preis [CHF]: ");
        orderPosition.setOrderedUnitPrice(input.nextInt());
        System.out.println("Anzahl: ");
        orderPosition.setOrderedQuantity(input.nextInt());

        return orderPosition;
    }

    private void showElementIndex(){
        System.out.println("---------------");
        System.out.println("Ausgabe mit Index");
        System.out.print("Index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println();
        System.out.println(MainController.orderPosition.getElement(index).toString());
    }

    private void showElement(){
        System.out.println("---------------");
        System.out.println("Ausgabe");
        System.out.println();
        for(OrderPosition orderPosition : MainController.orderPosition.getElement()){
            System.out.println(orderPosition.toString());
        }
    }

    private void updateElement(){
        System.out.println("---------------");
        System.out.println("Bearbeiten");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.orderPosition.setElement(index, showElementInput());
    }

    private void deleteElement(){
        System.out.println("---------------");
        System.out.println("Löschen");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.orderPosition.removeElement(index);
    }
}
