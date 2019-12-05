package menu.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static menu.App.GetChoice.getChoice;

public class Submenu1{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void doSomething() {
        stdout.info("Submenu 1\n");
        stdout.info("Wybierz 0, żeby wrócić\n");
        int choice = getChoice();
        switch (choice) {
            case 0:
                Menu.mainMenu();
                break;
            default:
                doSomething();
        }
    }
}
