//package View;
//
//import Controller.MainController;
//import Model.Model;
//
//import java.util.Scanner;
//
//public abstract class SubMenu<ModelType extends Model> {
//    protected Class<? extends Model> model;
//
//    public SubMenu(Class<ModelType> model) {
//        this.model = model;
//    }
//
//    protected boolean closeSubMenu = false;
//    public void startViewLoop(String title){
//        while (!closeSubMenu){
//            showSubMenu(title);
//            selectSubMain();
//        }
//    }
//
//    protected void showSubMenu(String title){
//        System.out.println("+++++++++++++++");
//        System.out.println(title);
//        System.out.println();
//        System.out.println("[1] Hinzufügen");
//        System.out.println("[2] Anzeigen alle");
//        System.out.println("[3] Anzeigen mit Index");
//        System.out.println("[4] Bearbeiten");
//        System.out.println("[5] Löschen");
//        System.out.println("[s] Speichern");
//        System.out.println("[e] Zurück");
//    }
//
//    protected void selectSubMain(){
//
//    }
//
//    protected abstract ModelType showElementInput();
//
//    protected void showElementIndex(){
//        System.out.println("---------------");
//        System.out.println("Ausgabe mit Index");
//        System.out.print("Index: ");
//        Scanner input = new Scanner(System.in);
//        int index = input.nextInt();
//        System.out.println();
//        System.out.println(MainController.getController(model).getElement(index).toString());
//    }
//
//    protected void showElement(){
//        System.out.println("---------------");
//        System.out.println("Ausgabe");
//        System.out.println();
//        for(Model element : MainController.getController(model).getElement()){
//            System.out.println(((ModelType)element).toString());
//        }
//    }
//
//    protected void updateElement(){
//        System.out.println("---------------");
//        System.out.println("Bearbeiten");
//        Scanner input = new Scanner(System.in);
//        System.out.print("Index: ");
//        int index = input.nextInt();
//        System.out.println();
//        MainController.getController(model).setElement(index, showElementInput());
//    }
//}