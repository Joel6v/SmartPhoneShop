package View;

import Controller.MainController;
import Model.Order;
import Model.OrderPosition;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView implements ISubMenu{

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
        System.out.println("Bestellungen");
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
                Order order = showElementInput();
                MainController.order.setElement(order);
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
                MainController.order.save();
            }break;
            case "e": {
                closeMenu = true;
            }break;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    public Order showElementInput(){
        Order order = new Order();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Eingabe Bestellung");
        System.out.println();

        System.out.print("Bestelldatum [dd.MM.yyyy HH:mm:ss]: ");
        order.setOrderDate(input.nextLine());
        System.out.print("Lieferadresse [1]: ");
        order.setShippingAddress(MainController.address.getElement(Integer.parseInt(input.nextLine())));
        System.out.print("Kunde [1]: ");
        order.setOrderedByCustomer(MainController.customer.getElement(Integer.parseInt(input.nextLine())));
        System.out.print("Positionen [1, 2]: ");
        order.setOrderPositions(addOrderPosition(input.nextLine()));
        order.setTotalPrice();
        order.setOrderNumber();

        return order;
    }

    private ArrayList<OrderPosition> addOrderPosition(String input) throws NumberFormatException, IndexOutOfBoundsException {
        ArrayList<OrderPosition> orderPositions = new ArrayList<>();
        String[] indexes = input.split(" ,");

        for(String index : indexes){
            orderPositions.add(MainController.orderPosition.getElement(Integer.parseInt(index)));
        }

        return orderPositions;
    }

    private void showElementIndex(){
        System.out.println("---------------");
        System.out.println("Ausgabe mit Index");
        System.out.print("Index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println();
        System.out.println(MainController.order.getElement(index).toString());
    }

    private void showElement(){
        System.out.println("---------------");
        System.out.println("Ausgabe");
        System.out.println();
        for(Order order : MainController.order.getElement()){
            System.out.println(order.toString());
        }
    }

    private void updateElement(){
        System.out.println("---------------");
        System.out.println("Bearbeiten");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.order.setElement(index, showElementInput());
    }

    private void deleteElement(){
        System.out.println("---------------");
        System.out.println("Löschen");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.order.removeElement(index);
    }
}
