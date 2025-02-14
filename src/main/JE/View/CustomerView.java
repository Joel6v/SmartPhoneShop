package View;

import Controller.*;
import Model.Address;
import Model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerView implements ISubMenu{
    private MainController controller;

    public CustomerView(MainController controller) {
        this.controller = controller;
    }

    public void startView(){

    }

    public void showSubMenu(){
        System.out.println("+++++++++++++++");
        System.out.println("Kunden");
        System.out.println();
        System.out.println("[1] Hinzufügen");
        System.out.println("[2] Anzeigen alle");
        System.out.println("[3] Anzeigen mit Id");
        System.out.println("[4] Bearbeiten");
        System.out.println("[5] Löschen");
        System.out.println("[e] Zurück");
    }

    public void selectSubMain(){
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        switch(selection){
            case "1":{
                controller.customer.setElement(showInputCustomer());
            }break;
            case "2":{

            }break;
            case "3":{

            }break;
            case "4":{

            }break;
            case "5":{

            }break;
            case "e": return;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    private Customer showInputCustomer(){
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
        addAddress(input.nextLine());
        System.out.print("Telefon privat: ");
        customer.setPhoneNumberPrivate(input.nextLine());
        System.out.print("Telefon mobil: ");
        customer.setPhoneNumberMobile(input.nextLine());
        System.out.print("Email: ");
        customer.setEmail(input.nextLine());
        System.out.print("Geburtsdatum: ");
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
            addresses.add(controller.address.getElement(Integer.parseInt(index)));
        }

        return addresses;
    }

    private void showCustomer(int index){

    }

    private void showCustomer(){

    }
}
