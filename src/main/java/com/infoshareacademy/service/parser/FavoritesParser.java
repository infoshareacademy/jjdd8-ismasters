package com.infoshareacademy.service.parser;


import com.infoshareacademy.repository.FavoritesRepository;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FavoritesParser {


    public void initialization(String filename) throws IOException {
        FavoritesParser favoritesParser = new FavoritesParser();
        favoritesParser.parseData(filename);
    }

    private void parseData(String filename) throws IOException {
        String[] favorites;
        Reader reader = Files.newBufferedReader(Paths.get(filename));

        CSVReader csvReader = new CSVReader(reader);

        favorites = csvReader.readNext();

        FavoritesRepository.setFavoritesList(favorites);
    }
}
