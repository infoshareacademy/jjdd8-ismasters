package menu.App;

import java.util.Scanner;
import static menu.App.GetChoice.getChoice;

public class Menu {

    public static void main(String[] args) {
        mainMenu();


    }

    public static void mainMenu() {
        System.out.println("Witaj w kalendarzu wydarzeń kulturalnych");
        System.out.println("Najbliższe nadchodzące wydarzenia:");
        //TODO: POkaz najbliższe wydarzenia

        System.out.println("Wybierz menu:");
        System.out.println("1. Pokaż wszystkie wydarzenia");
        System.out.println("2. Pokaż wydarzenia wg organizatora");
        System.out.println("3. Znajdź wydarzenie wg daty");
        System.out.println("");
        System.out.println("Wpisz liczbę");

        int choice = getChoice();
        System.out.println(choice);

        switch (choice) {
            case 1:
                System.out.println("Wybór menu 1");
                new Submenu1().doSomething();
                break;
            case 2:
                //TODO metoda2
                System.out.println("Wybór menu 2");
                break;
            case 3:
                //TODO metoda 3
                System.out.println("Wybór menu 3");
                break;
            default:
                //TODO metoda 1
                System.out.println("default");

        }
    }


}
