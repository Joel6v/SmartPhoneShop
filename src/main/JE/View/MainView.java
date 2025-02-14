package View;

import java.util.Scanner;

public class MainView {
    private void showMainMenu(){
        System.out.println("###############");
        System.out.println("Smartphone Shop");
        System.out.println();
        System.out.println("[1] Menu Smartphones");
        System.out.println("[2] Menu Kunden");
        System.out.println("[3] Menu Bestellungen");
        System.out.println("[e] Verlassen");
    }

    private void selectMainMenu(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        switch(selection){
            case "1":
            {
                showSubMenu("Menu Smartphones");
                selectSubMenuSmartphones();
            }break;
            case "2":{
                showSubMenu("Menu Kunden");
                selectSubMenuCustomers();
            }break;
            case "3":{
                showSubMenu("Menu Bestellungen");
                selectSubMenuOrders();
            }break;
            case "e":{
                System.exit(0);
            }break;
            default:{
                printWrongSelectionError();
            }break;
        }
    }

    public static void printWrongSelectionError(){
        System.out.println("!!!!!!!!!!!!!!!");
        System.out.println("Ungültige Auswahl");
        System.out.println("Bitte wähle eine gültige Option!");
    }

    private void selectSubMenuCustomers(){
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
    }

    private void selectSubMenuOrders(){
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
    }
}
