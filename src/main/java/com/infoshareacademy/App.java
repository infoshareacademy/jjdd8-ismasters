package com.infoshareacademy;

import com.infoshareacademy.repository.FavoritesRepository;
import com.infoshareacademy.service.parser.FavoritesParser;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private static final String SAMPLE_CSV_FILE_PATH = "./favorites.csv";


    public static void main(String[] args) {
        final String JSON = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(JSON);
//        Menu.mainMenu();


        FavoritesParser favoritesParser = new FavoritesParser();
        favoritesParser.initialization(SAMPLE_CSV_FILE_PATH);

        Arrays.stream(FavoritesRepository.getFavoritesList())
                .map(x -> x.equals("") ? "Empty" : "Value: " + x)
                .forEach(System.out::println);

        FavoritesRepository.setFavoriteEvent(0, "aaa");

        new FavoritesParser().writeCSV(SAMPLE_CSV_FILE_PATH);
        System.out.println();
        new FavoritesParser().readCSV(SAMPLE_CSV_FILE_PATH);

        Arrays.stream(FavoritesRepository.getFavoritesList())
                .map(x -> x.equals("") ? "Empty" : "Value: " + x)
                .forEach(System.out::println);
    }
}