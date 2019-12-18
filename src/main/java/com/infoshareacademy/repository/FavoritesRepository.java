package com.infoshareacademy.repository;

public class FavoritesRepository {
    private static String[] favoritesList = new String[3];

    public static void setFavoritesList(String[] favoritesList) {
        FavoritesRepository.favoritesList = favoritesList;
    }

    public static String[] getFavoritesList() {
        return favoritesList;
    }

    public static void setFavoriteEvent(int index, String value) {
        favoritesList[index] = value;
    }
}
