package com.infoshareacademy.menu;

import com.infoshareacademy.menu.util.InputValidator;
import com.infoshareacademy.repository.FavoritesRepository;
import com.infoshareacademy.service.parser.FavoritesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FavoritesPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public void showAllFavorites() {
        FavoritesParser.readCSV(Menu.FAVORITES_CSV_FILE_PATH);
        FavoritesParser.showStoredEvents();
    }

    public void removeFavorite() {
        String input;
        do {
            stdout.info("Podaj numer ID wydarzenia do usunięcia (5 cyfr)\n");
            Menu.scanner.nextLine();
            input = Menu.scanner.next();
            if (input.toLowerCase().equals("q")) {
                break;
            }
            if (!InputValidator.checkFiveDigitRangeInput(input)) {
                stdout.info("\nPodano niepoprawne ID\n");
                stdout.info("\nWpisz poprawne ID lub wpisz Q, aby wyjść\n");
            }
        }
        while (!InputValidator.checkFiveDigitRangeInput(input) || input.toLowerCase().equals("q"));

        if (!input.toLowerCase().equals("q")) {
            FavoritesParser.removeFavoriteEvent(Integer.valueOf(input));
        }
    }

    public void addFavorite() {
        FavoritesParser.readCSV(Menu.FAVORITES_CSV_FILE_PATH);
        String input = "";
        if (FavoritesRepository.getFavoritesList().size() >= 3) {
            stdout.info("\nLista ulubionych ma już maksymalną możliwą wielkość\n");
            stdout.info("Usuń coś z ulubionych, aby dodać inną pozycję\n\n");
        } else {
            do {
                stdout.info("Podaj numer ID wydarzenia do dodania (5 cyfr)\n");
                Menu.scanner.nextLine();
                input = Menu.scanner.next();
                if (input.toLowerCase().equals("q")) {
                    break;
                }
                if (!InputValidator.checkFiveDigitRangeInput(input)) {
                    stdout.info("\nPodano niepoprawne ID\n");
                    stdout.info("\nWpisz poprawne ID lub wpisz Q, aby wyjść\n");
                }
            }
            while (!InputValidator.checkFiveDigitRangeInput(input) || input.toLowerCase().equals("q"));
        }

        if (!input.toLowerCase().equals("q") && !input.equals("")) {
            FavoritesParser.addFavoriteEvent(Integer.valueOf(input));
        }
    }
}
