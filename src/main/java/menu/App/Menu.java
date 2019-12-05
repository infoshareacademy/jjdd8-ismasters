package menu.App;

import static menu.App.GetChoice.getChoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        stdout.info("Witaj w kalendarzu wydarzeń kulturalnych\n");
        stdout.info("Najbliższe nadchodzące wydarzenia:\n");
        //TODO: POkaz najbliższe wydarzenia

        stdout.info("Wybierz menu:\n");
        stdout.info("1. Pokaż najbliższe wydarzenia\n");
        stdout.info("2. Pokaż wydarzenia wg organizatora\n");
        stdout.info("3. Znajdź wydarzenie wg daty\n");
        stdout.info("\n");
        stdout.info("Wpisz liczbę\n");

        int choice = getChoice();
        stdout.info(String.valueOf(choice));

        switch (choice) {
            case 1:
                stdout.info("Wybór menu 1\n");
                new Submenu1().doSomething();
                break;
            case 2:
                //TODO metoda2
                stdout.info("Wybór menu 2\n");
                new Submenu2().doSomething();
                break;
            case 3:
                //TODO metoda 3
                stdout.info("Wybór menu 3\n");
                break;
            default:
                //TODO metoda 1
                stdout.info("default\n");

        }
    }


}
