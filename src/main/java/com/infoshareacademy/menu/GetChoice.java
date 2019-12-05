package menu.App;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static menu.App.Menu.clearScreen;
import static menu.App.Menu.scanner;

public class GetChoice {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        int result = 500;

        try {
            clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stdout.info("\nPodaj liczbę");
        stdout.info("\nPodaj 9, aby wyjść\n");

        try {
            String in = scanner.next();
            if (StringUtils.containsOnly(in, "0123456789") && (Integer.parseInt(in) <= 9)) {
                try {
                    result = Integer.parseInt(in);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Zła liczba, podaj nową");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
