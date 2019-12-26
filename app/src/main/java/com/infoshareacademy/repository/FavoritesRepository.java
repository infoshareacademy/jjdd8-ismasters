package com.infoshareacademy.repository;

import java.util.ArrayList;
import java.util.List;

public class FavoritesRepository {


    private static List<Integer> favoritesList = new ArrayList<>();

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
