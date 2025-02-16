package View;

import Controller.MainController;

import java.util.Scanner;

public class MainView {

    public void startView() {
        showMainMenu();
        selectMainMenu();
    }

    private boolean closeProgram = false;
    public void startViewLoop(){
        while(!closeProgram){
            showMainMenu();
            selectMainMenu();
        }
    }

    private void showMainMenu(){
        System.out.println("###############");
        System.out.println("Smartphone Shop");
        System.out.println();
        System.out.println("[1] Menu Adressen");
        System.out.println("[2] Menu Smartphones");
        System.out.println("[3] Menu Kunden");
        System.out.println("[4] Menu Bestellpositionen");
        System.out.println("[5] Menu Bestellungen");
        System.out.println("[s] Alles speichern");
        System.out.println("[e] Programm schliessen");
    }

    private void selectMainMenu(){
        System.out.print("Auswahl: ");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        switch(selection){
            case "1":
            {
                AddressView addressView = new AddressView();
                addressView.startViewLoop();
            }break;
            case "2":{

            }break;
            case "3":{
                CustomerView customerView = new CustomerView();
                customerView.startViewLoop();
            }break;
            case "4":{

            }break;
            case "5":{

            }break;
            case "s":{
                MainController.saveAll();
            }break;
            case "e":{
                closeProgram = true;
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
}
