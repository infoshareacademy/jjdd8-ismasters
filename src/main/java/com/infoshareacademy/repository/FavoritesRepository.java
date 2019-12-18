package com.infoshareacademy.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FavoritesRepository {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private static List<Integer> favoritesList = new ArrayList<>();

    public static void setFavoritesList(List<Integer> favoritesList) {
        FavoritesRepository.favoritesList = favoritesList;
    }

    public static List<Integer> getFavoritesList() {
        return favoritesList;
    }

    public static void add(Integer value) {
        favoritesList.add(value);
    }
    public static void remove(Integer value) {
        favoritesList.remove(value);
    }


}
