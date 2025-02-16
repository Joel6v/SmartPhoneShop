import Controller.MainController;
import View.MainView;

public class Program {
    public static void main(String[] args) {
        MainController.setInstanceAll();
        MainView mainView = new MainView();
        mainView.startViewLoop();
    }
}
