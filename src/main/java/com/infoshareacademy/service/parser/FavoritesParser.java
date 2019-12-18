package com.infoshareacademy.service.parser;


import com.infoshareacademy.repository.FavoritesRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FavoritesParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void initializeCsvParser(String filename) {
        readCSV(filename);
    }

    public static void readCSV(String filename) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            CSVReader csvReader = new CSVReader(reader);

            String[] tempArr;
            List<Integer> favorites = new ArrayList<>();

            while ((tempArr = csvReader.readNext()) != null) {
                favorites.add(Integer.parseInt(tempArr[0]));
            }

            FavoritesRepository.setFavoritesList(favorites);

        } catch (IOException e) {
            stdout.info("Błąd pliku " + e.getMessage());
        }
    }

    public static void writeCSV(String filename) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filename));
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            for (Integer i : FavoritesRepository.getFavoritesList()) {
                csvWriter.writeNext(new String[]{i.toString()});
            }
        } catch (Exception e) {
            stdout.info("Błąd pliku " + e.getMessage());
        }
    }

    public static void addFavoriteEvent(Integer value) {
        if (value != null && FavoritesRepository.getFavoritesList().size() >= 3) {
            stdout.info("\nLista ulubionych ma już maksymalną możliwą wielkość\n");
            stdout.info("Usuń coś z ulubionych, aby dodać inną pozycję\n");
        } else {
            FavoritesRepository.getFavoritesList().add(value);
            stdout.info("\nDodano do ulubionych pozycję o numerze " + value + "\n");
        }
    }

    public static void removeFavoriteEvent(Integer value) {
        if (value != null && FavoritesRepository.getFavoritesList().contains(value)) {
            FavoritesRepository.getFavoritesList().remove(value);
            stdout.info("\nUsunięto z listy ulubionych pozycję o numerze " + value + "\n");
        } else {
            stdout.info("\nNa liście ulubionych nie ma pozycji " + value + "\n");
        }
    }
}

