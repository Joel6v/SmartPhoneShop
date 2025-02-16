package View;

import Controller.MainController;
import Model.Address;
import Model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressView implements ISubMenu{

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
        System.out.println("Adressen");
        System.out.println();
        System.out.println("[1] Hinzufügen");
        System.out.println("[2] Anzeigen alle");
        System.out.println("[3] Anzeigen mit Id");
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
                Address address = showElementInput();
                MainController.address.setElement(address);
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
                MainController.address.save();
            }break;
            case "e": {
                closeMenu = true;
            }break;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    public Address showElementInput(){
        Address address = new Address();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Eingabe Address");
        System.out.println();

        System.out.println("Strasse: ");
        address.setStreet(input.nextLine());
        System.out.println("PLZ: ");
        address.setZipCode(input.nextLine());
        System.out.println("Stadt: ");
        address.setCity(input.nextLine());

        return address;
    }

    private void showElementIndex(){
        System.out.println("---------------");
        System.out.println("Ausgabe mit Index");
        System.out.print("Index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println();
        System.out.println(MainController.address.getElement(index).toString());
    }

    private void showElement(){
        System.out.println("---------------");
        System.out.println("Ausgabe");
        System.out.println();
        for(Address address : MainController.address.getElement()){
            System.out.println(address.toString());
        }
    }

    private void updateElement(){
        System.out.println("---------------");
        System.out.println("Bearbeiten");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.address.setElement(index, showElementInput());
    }

    private void deleteElement(){
        System.out.println("---------------");
        System.out.println("Löschen");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.address.removeElement(index);
    }
}
