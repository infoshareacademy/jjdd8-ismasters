package com.infoshareacademy.menu;

import com.infoshareacademy.service.parser.FavoritesParser;
import com.infoshareacademy.repository.FavoritesRepository;

public class FavoritesShowAll {

    public void showAllFavorites() {
        FavoritesParser.readCSV(Menu.FAVORITES_CSV_FILE_PATH);
    }
}
