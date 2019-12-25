package com.infoshareacademy.service.parser;


import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.repository.FavoritesRepository;
import com.infoshareacademy.repository.FilterRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class FavoritesParser {

    private static final String FAVORITES_CSV_FILE_PATH = "./favorites.csv";


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


//    public static void initializeCsvParser(String filename) {
//        readCSV(filename);
//    }

    public static void readCSV(String filename) {

        FavoritesRepository.getFavoritesList().clear();

        try {
            File file = new File(Menu.FAVORITES_CSV_FILE_PATH);
            file.createNewFile();

            Reader reader = Files.newBufferedReader(Paths.get(filename));
            CSVReader csvReader = new CSVReader(reader);

            String[] tempArr;
            List<Integer> favorites = new ArrayList<>();

            while ((tempArr = csvReader.readNext()) != null) {
                if (!tempArr[0].equals("")) {
                    favorites.add(Integer.parseInt(tempArr[0]));
                }
            }

            FavoritesRepository.getFavoritesList().addAll(favorites);

        } catch (CsvValidationException | IOException e) {
            stdout.info("Błąd odczytu pliku " + e.getMessage());
        }
    }

    public static void writeCSV(String filename) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filename), TRUNCATE_EXISTING);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            for (Integer i : FavoritesRepository.getFavoritesList()) {
                csvWriter.writeNext(new String[]{i.toString()});
            }
        } catch (IOException e) {
            stdout.info("Błąd zapisu do pliku " + e.getMessage());
        }
    }

    /**
     * This method checks if the event list file has 3 or less events stored.
     *
     * @param value Event id to be added to CSV file
     */
    public static void addFavoriteEvent(Integer value) {

            FavoritesRepository.getFavoritesList().add(value);
            writeCSV(FAVORITES_CSV_FILE_PATH);
            stdout.info("\nDodano do ulubionych pozycję o numerze " + value + "\n\n");

    }

    public static void removeFavoriteEvent(Integer value) {
        if (value != null && FavoritesRepository.getFavoritesList().contains(value)) {
            FavoritesRepository.getFavoritesList().remove(value);
            writeCSV(FAVORITES_CSV_FILE_PATH);
            stdout.info("\nUsunięto z listy ulubionych pozycję o numerze " + value + "\n\n");
        } else {
            stdout.info("\nNa liście ulubionych nie ma pozycji " + value + "\n\n");
        }
    }

    public static void showStoredEvents() {
        if (FavoritesRepository.getFavoritesList().isEmpty()) {
            stdout.info("\nBrak pozycji na liście ulubionych wydarzeń\n\n");
        } else {
            stdout.info("\nLista ulubionych wydarzeń:\n\n");


            FavoritesRepository.getFavoritesList()
                    .forEach(fav -> stdout.info("Numer id: " + fav + ", " +
                            new FilterRepository().filterWithLambdaPassedIn(event -> event.getid() == fav)
                                    .stream()
                                    .map(z -> z.getName() + ", " + z.getPlace().getName())
                                    .findFirst()
                                    .orElse("Brak takiego wydarzenia")
                            + "\n"));

            stdout.info("\n");
        }
    }
}

