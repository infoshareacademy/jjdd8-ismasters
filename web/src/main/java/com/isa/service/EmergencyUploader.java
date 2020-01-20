package com.isa.service;

import com.isa.service.constant.ConstantValuesBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Stateless
public class EmergencyUploader {

    @EJB
    ConstantValuesBean constantValuesBean;


    public String readJsonFromFile(String filename) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
