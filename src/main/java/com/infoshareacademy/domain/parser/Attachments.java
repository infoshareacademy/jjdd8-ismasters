package com.infoshareacademy.domain.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Attachments {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
