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

public class FavoritesParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    public void initialization(String filename) {
        FavoritesParser favoritesParser = new FavoritesParser();
        favoritesParser.readCSV(filename);
    }

    public void readCSV(String filename){

        try {
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            CSVReader csvReader = new CSVReader(reader);
            String[] favorites = csvReader.readNext().clone();
            System.out.println("Length: " + favorites.length);
            FavoritesRepository.setFavoritesList(favorites);

        } catch (Exception e) {
            stdout.info("Błąd pliku " + e.getMessage());
        }
    }



    public void writeCSV(String filename) {
        try ( Writer writer = Files.newBufferedWriter(Paths.get(filename));
              CSVWriter csvWriter = new CSVWriter(writer,
                      CSVWriter.DEFAULT_SEPARATOR,
                      CSVWriter.NO_QUOTE_CHARACTER,
                      CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                      CSVWriter.DEFAULT_LINE_END);) {

            csvWriter.writeNext(FavoritesRepository.getFavoritesList());




        } catch (Exception e) {
            stdout.info("Błąd pliku " + e.getMessage());
        }


    }
}

