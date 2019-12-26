package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FavoritesMenu {

    public static final String JSON_REPOSITORY = "JSON_example";

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private static final String FAVORITES_CSV_FILE_PATH = "./favorites.csv";


    static String first = "1. Pokaż ulubione wydarzenia";
    static String second = "2. Dodaj wydarzenie do ulubionych";
    static String third = "3. Usuń wydarzenie z ulubionych";
    static String exit = "9. Wyjdź go poprzedniego menu";


    void showFavoritesOnLoad() {
        FilterRepository filterRepository = new FilterRepository();

        int returnCheckInt = 0;

        while (returnCheckInt != 9) {

            if (!Menu.BREADCRUMBSTACK.peek().equals("Ulubione wydarzenia")) {
                Menu.BREADCRUMBSTACK.add("Ulubione wydarzenia");
            }
            BreadcrumbsPrinter.printBreadcrumbs();

            MenuBuilder.printFavoriteEvent();

            switch (ChoiceGetter.getChoice()) {
                case 1:

                    new FavoritesPrinter().showAllFavorites();
                    break;
                case 2:
                    new FavoritesPrinter().addFavorite();
                    break;
                case 3:
                    new FavoritesPrinter().removeFavorite();
                    break;
                case 9:
                    ScreenCleaner.cleanConsoleWindow();
                    Menu.BREADCRUMBSTACK.pop();
                    returnCheckInt = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }
}