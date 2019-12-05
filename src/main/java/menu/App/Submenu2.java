package menu.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Submenu2{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void doSomething() {
        int submenu2ExitCode = 0;
        stdout.info("submenu1");

        while (submenu2ExitCode != 9) {
            switch (GetChoice.getChoice()) {
                case 1:
                    stdout.info("Opcja submenu 2 - 1\n");
                    break;
                case 2:
                    //TODO metoda2
                    stdout.info("Opcja submenu 2 - 2\n");
                    break;
                case 9:
                    //TODO metoda 3
                    stdout.info("Opcja submenu 2 - 3\n");
                    submenu2ExitCode = 9;
                    break;
                default:
                    //TODO metoda 1
                    stdout.info("Submenu 2 - default\n");
            }
        }

    }
}
