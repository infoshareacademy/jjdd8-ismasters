package menu.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static menu.App.GetChoice.getChoice;

public class Submenu2 {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void doSomething() {
        stdout.info("Submenu 2\n");
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
