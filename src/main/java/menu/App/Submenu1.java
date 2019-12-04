package menu.App;

import static menu.App.GetChoice.getChoice;

public class Submenu1 {
    void doSomething() {
        System.out.println("Tu będzie się coś działo");
        System.out.println("Wybierz 0, żeby wrócić");
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
