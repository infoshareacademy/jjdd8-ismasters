package menu.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class GetChoice {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    //TODO walidacja stringów - jakie biblioteki
    public static int getChoice() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return choice;
    }
}
