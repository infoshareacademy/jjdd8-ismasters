package menu.App;

import java.util.Scanner;

public class GetChoice {

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
