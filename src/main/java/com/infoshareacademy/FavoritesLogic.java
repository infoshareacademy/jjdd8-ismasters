package com.infoshareacademy;

import com.infoshareacademy.repository.FavoritesRepository;
import com.infoshareacademy.service.parser.FavoritesParser;

public class FavoritesLogic {

    private static final String FAVORITES_CSV_FILE_PATH = "./favorites.csv";


    public static void main(String[] args) {

        FavoritesParser.readCSV(FAVORITES_CSV_FILE_PATH);

        System.out.println(FavoritesRepository.getFavoritesList().size());
        System.out.println(FavoritesRepository.getFavoritesList());

        FavoritesParser.addFavoriteEvent(200); // tym dodajemy ulubione eventy do pliku

        System.out.println("Show stored events");
        FavoritesParser.showStoredEvents();

        System.out.print("Rozmiar listy: ");
        System.out.println(FavoritesRepository.getFavoritesList().size());


        System.out.print("Lista: ");
        System.out.println(FavoritesRepository.getFavoritesList());

        FavoritesParser.writeCSV(FAVORITES_CSV_FILE_PATH);
    }

}
