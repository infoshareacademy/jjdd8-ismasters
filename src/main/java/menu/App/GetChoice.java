package menu.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class GetChoice {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.next();
            if (!StringUtils.containsOnly(choice, "0123456789")) {
                stdout.info("Nieprawidłowa liczba, jeszcze raz!");
                getChoice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(choice);
    }
}
