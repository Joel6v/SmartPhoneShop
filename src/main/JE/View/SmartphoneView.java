package View;

import Controller.MainController;
import Model.Address;
import Model.Smartphone;

import java.util.Scanner;

public class SmartphoneView implements ISubMenu{

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
        System.out.println("Smartphones");
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
                Smartphone smartphone = showElementInput();
                MainController.smartphone.setElement(smartphone);
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
                MainController.smartphone.save();
            }break;
            case "e": {
                closeMenu = true;
            }break;
            default: {
                MainView.printWrongSelectionError();
            }break;
        }
    }

    public Smartphone showElementInput(){
        Smartphone smartphone = new Smartphone();
        Scanner input = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Eingabe Smartphones");
        System.out.println();

        System.out.println("Marke: ");
        smartphone.setBrand(input.nextLine());
        System.out.println("Modell: ");
        smartphone.setModel(input.nextLine());
        System.out.println("Preis [CHF]: ");
        smartphone.setUnitPrice(input.nextInt());
        System.out.println("RAM [GiB]: ");
        smartphone.setRam(input.nextInt());
        System.out.println("Bildschirm [Zoll]: ");
        smartphone.setScreenSize(input.nextInt());
        System.out.println("Betriebssystem: ");
        smartphone.setOs(input.nextLine());
        System.out.println("Bildschirmgrösse Breite [Pixel]: ");
        smartphone.setScreenResolutionWidth(input.nextInt());
        System.out.println("Bildschirmgrösse Höhe [Pixel]: ");
        smartphone.setScreenResolutionHeight(input.nextInt());
        System.out.println("Prozessor Kerne Anz.: ");
        smartphone.setProcessorCores(input.nextInt());
        System.out.println("Batterie Grösse [Wh]: ");
        smartphone.setBatteryCapacity(input.nextInt());
        System.out.println("Konnektivität [NFC, WLAN]: ");
        smartphone.setConnectivity(input.nextLine());
        System.out.println("Mobilfunktstandart: ");
        smartphone.setMobileStandard(input.nextLine());

        return smartphone;
    }

    private void showElementIndex(){
        System.out.println("---------------");
        System.out.println("Ausgabe mit Index");
        System.out.print("Index: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println();
        System.out.println(MainController.smartphone.getElement(index).toString());
    }

    private void showElement(){
        System.out.println("---------------");
        System.out.println("Ausgabe");
        System.out.println();
        for(Smartphone smartphone : MainController.smartphone.getElement()){
            System.out.println(smartphone.toString());
        }
    }

    private void updateElement(){
        System.out.println("---------------");
        System.out.println("Bearbeiten");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.smartphone.setElement(index, showElementInput());
    }

    private void deleteElement(){
        System.out.println("---------------");
        System.out.println("Löschen");
        Scanner input = new Scanner(System.in);
        System.out.print("Index: ");
        int index = input.nextInt();
        System.out.println();
        MainController.smartphone.removeElement(index);
    }
}
