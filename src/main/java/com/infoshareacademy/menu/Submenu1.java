package com.infoshareacademy.menu;

import com.infoshareacademy.menu.GetChoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Submenu1{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void doSomething() {
        int submenu1ExitCode = 0;

        while (submenu1ExitCode != 9) {
            stdout.info("----------------------------------\n");
            stdout.info("\nWybierz :\n");
            stdout.info("1. Submenu 1\n");
            stdout.info("2. Submenu 2\n");
//            stdout.info("3. Submenu 3\n");
            stdout.info("\n");
            stdout.info("9. Wyjście\n");

            switch (GetChoice.getChoice()) {
                case 1:
                    stdout.info("Opcja submenu 1 - 1\n");
                    break;
                case 2:
                    //TODO metoda2
                    stdout.info("Opcja submenu 1 - 2\n");
                    break;
                case 9:
                    //TODO metoda 3
                    stdout.info("WYCHODZĘ DO WYŻSZEGO MENU\n");
                    submenu1ExitCode = 9;
                    break;
                default:
                    //TODO metoda 1
                    stdout.info("ZŁY WYBÓR\n");
            }
        }

    }
}
