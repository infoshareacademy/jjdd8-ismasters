package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.NearestEventInTime;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        loadConfig();
        final String JSON = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(JSON);
        Menu.mainMenu();
//        NearestEventInTime.nearestInTime();
    }

    public static void loadConfig(){
        try {
            File configFile = new File("config.properties");
            FileReader reader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e){
            stdout.info("\nBrak pliku ustawień");
        } catch (IOException ex){
            stdout.info("\nBłąd odczytu pliku");
        }
    }
}