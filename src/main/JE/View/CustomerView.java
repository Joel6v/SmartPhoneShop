package View;

import Controller.*;
import Model.Address;
import Model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView implements ISubMenu{

    public CustomerView() {
    }

    private boolean closeMenu = false;
    @Override
    public void startViewLoop(){
        while(!closeMenu){
            showSubMenu();
            selectSubMain();
        }
    }

    public void showSubMenu(){
        System.out.println("+++++++++++++++");
        System.out.println("Kunden");
        System.out.println();
        System.out.println("[1] Hinzufügen");
        System.out.println("[2] Anzeigen alle");
        System.out.println("[3] Anzeigen mit Index");
        System.out.println("[4] Bearbeiten");
        System.out.println("[5] Löschen");
        System.out.println("[s] Speichern");
        System.out.println("[e] Zurück");
    }

    public void selectSubMain(){
        System.out.print("Auswahl: ");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        switch(selection){
            case "1":{
                MainController.customer.setElement(showElementInput());
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
                MainController.customer.save();
            }break;
            case "e": {
                closeMenu = true;
            }break;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    public Customer showElementInput(){
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Eingabe Kunde");
        System.out.println();

        System.out.print("Titel: ");
        customer.setSalutation(input.nextLine());
        System.out.print("Nachname: ");
        customer.setLastName(input.nextLine());
        System.out.print("Vorname: ");
        customer.setFirstName(input.nextLine());
        System.out.print("Addressen [1, 2]: ");
        customer.setAddresses(addAddress(input.nextLine()));
        System.out.print("Telefon privat: ");
        customer.setPhoneNumberPrivate(input.nextLine());
        System.out.print("Telefon mobil: ");
        customer.setPhoneNumberMobile(input.nextLine());
        System.out.print("Email: ");
        customer.setEmail(input.nextLine());
        System.out.print("Geburtsdatum [14.12.2000]: ");
        customer.setDateOfBirth(input.nextLine());
        System.out.print("Benutzername: ");
        customer.setUsername(input.nextLine());
        System.out.print("Passwort: ");
        customer.setPassword(input.nextLine());

        return customer;
    }

    private ArrayList<Address> addAddress(String input) throws NumberFormatException, IndexOutOfBoundsException {
        ArrayList<Address> addresses = new ArrayList<>();
        String[] indexes = input.split(" ,");

        for(String index : indexes){
            addresses.add(MainController.address.getElement(Integer.parseInt(index)));
        }

        return addresses;
    }

    private void showElementIndex(){
        System.out.println("---------------");
        System.out.println("Ausgabe mit Index");
        System.out.print("Index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println();
        System.out.println(MainController.customer.getElement(index).toString());
    }

    private void showElement(){
        System.out.println("---------------");
        System.out.println("Ausgabe");
        System.out.println();
        for(Customer customer : MainController.customer.getElement()){
            System.out.println(customer.toString());
        }
    }

    private void updateElement(){
        System.out.println("---------------");
        System.out.println("Bearbeiten");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.customer.setElement(index, showElementInput());
    }

    private void deleteElement(){
        System.out.println("---------------");
        System.out.println("Löschen");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.customer.removeElement(index);
    }
}
